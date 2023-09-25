package com.myntra.service;


import com.myntra.dto.AddressDto;
import com.myntra.dto.UserDto;
import com.myntra.entity.AddressEntity;
import com.myntra.entity.UserEntity;
import com.myntra.exception.ApiRuntimeException;
import com.myntra.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
	private static final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);
	@Autowired
	private AddressRepository addressRepository;

	ModelMapper mapper = new ModelMapper();

	@Override
	public AddressDto create(AddressDto address) {
		try {
			log.info("Address saved successfully");
			AddressEntity userAddress = mapper.map(address, AddressEntity.class);
			AddressEntity addressEntity = addressRepository.save(userAddress);

			AddressDto addressDto = mapper.map(addressEntity, AddressDto.class);
			return addressDto;
		} catch (Exception e) {
			log.error("", e);

		}
		return null;
	}

	@Override
	public List<AddressDto> getAll() {

		List<AddressEntity> addressEntity = addressRepository.findAll();
		List<AddressDto> addressList = new ArrayList<AddressDto>();
		for (AddressEntity AddressEntity : addressEntity) {

			AddressDto addressDto = mapper.map(AddressEntity, AddressDto.class);
			addressList.add(addressDto);
		}
		return addressList;
	}

	@Override
	public AddressDto update(AddressDto AddressDto) {
		if (StringUtils.isEmpty(AddressDto.getId())) {
			throw new ApiRuntimeException("Address ID cannot be NULL or Empty to UpdateItem", "NOT_FOUND",
					HttpStatus.NOT_FOUND);
		}

		log.info("updating item {}", AddressDto.toString());
		AddressEntity addressEntity = mapper.map(AddressDto, AddressEntity.class);

		AddressEntity address = addressRepository.save(addressEntity);
		log.info("Address updated successfully");

		AddressDto addressDto = mapper.map(address, AddressDto.class);
		return addressDto;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			log.info("Deleting ItemDetails  for Id {}, ", id);
			AddressDto addressDto = getById(id);
			AddressEntity addressEntity = mapper.map(addressDto, AddressEntity.class);
			addressRepository.delete(addressEntity);
			return true;
		} catch (Exception e) {
			log.error("Error while deleting address for Id : {}", id);
			throw new ApiRuntimeException("Error while deleting address for Id " + id, "INTERNAL_ERROR",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public AddressDto getById(Long id) {
		log.info("Getting ItemDetails  for Id {}, ", id);
		Optional<AddressEntity> addressEntityOptional = addressRepository.findById(id);
		if (addressEntityOptional.isPresent()) {

			AddressEntity addressEntity = addressEntityOptional.get();
			AddressDto AddressDto = mapper.map(addressEntity, AddressDto.class);

			UserEntity userEntity = addressEntity.getUser();
			if (userEntity != null) {
				UserDto userDto = mapper.map(userEntity, UserDto.class);
				AddressDto.setUserDto(userDto);
			}
			return AddressDto;
		}
		log.error("Address not found for Id : {}", id);
		throw new ApiRuntimeException("Address Not Found for ID: " + id, "NOT_FOUND", HttpStatus.NOT_FOUND);
	}

}
