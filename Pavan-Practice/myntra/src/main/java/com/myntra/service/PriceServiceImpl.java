package com.myntra.service;


import com.myntra.dto.PriceDto;
import com.myntra.entity.PriceEntity;
import com.myntra.exception.ApiRuntimeException;
import com.myntra.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class PriceServiceImpl implements PriceService {


	@Autowired
	private PriceRepository itemRepository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public PriceDto create(PriceDto priceDto) {
		log.info("saving ItemPrice to database");

		try {

			ModelMapper mapper = new ModelMapper();
			PriceEntity priceEntity = mapper.map(priceDto, PriceEntity.class);

			PriceEntity createdItem = itemRepository.save(priceEntity);
			log.info("saved ItemPrice to database");
			priceDto = mapper.map(createdItem, PriceDto.class);
			return priceDto;

		} catch (Exception e) {
			log.error("error-saving ItemPrice to database");
		}
		return null;
	}

	@Override
	public List<PriceDto> getAll() {
		List<PriceEntity> items = itemRepository.findAll();

		List<PriceDto> priceDtosList = new ArrayList<>();

		for (PriceEntity PriceEntity : items) {

			PriceDto priceDto = mapper.map(PriceEntity, PriceDto.class);

			priceDtosList.add(priceDto);

		}
		return priceDtosList;
	}

	@Override
	public PriceDto update(PriceDto PriceDto) {
		if (ObjectUtils.isEmpty(PriceDto.getId())) {
			throw new ApiRuntimeException("PriceDto ID cannot be NULL or Empty to UpdateItem", "NOT_FOUND",
					HttpStatus.NOT_FOUND);
		}

		log.info("updating item ");
		PriceEntity priceEntity = mapper.map(PriceDto, PriceEntity.class);

		itemRepository.save(priceEntity);
		log.info("Item updated successfully");

		return  mapper.map(priceEntity, PriceDto.class);

	}

	@Override
	public Boolean delete(Long id) {
		try {
			log.info("Deleting ItemDetails  for Id {}, ", id);
			PriceDto PriceDto = getById(id);
			PriceEntity PriceEntity = mapper.map(PriceDto, PriceEntity.class);
			itemRepository.delete(PriceEntity);
			return true;
		} catch (Exception e) {
			log.error("Error while deleting item for Id : {}", id);
			throw new ApiRuntimeException("Error while deleting item for Id " + id, "INTERNAL_ERROR",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public PriceDto getById(Long id) {
		log.info("Getting ItemDetails  for Id {}, ", id);
		Optional<PriceEntity> priceEntityOptional = itemRepository.findById(id);
		if (priceEntityOptional.isPresent()) {
			PriceEntity priceEntity = priceEntityOptional.get();
			return  mapper.map(priceEntity, PriceDto.class);

		}
		log.error("Item not found for Id : {}", id);
		throw new ApiRuntimeException("Item Not Found for ID: " + id, "NOT_FOUND", HttpStatus.NOT_FOUND);
	}

}
