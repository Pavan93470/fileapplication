package com.myntra.service;


import com.myntra.dto.CartDto;
import com.myntra.entity.CartEntity;
import com.myntra.exception.ApiRuntimeException;
import com.myntra.repository.CartRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceUserImpl implements CartService {
	private static final Logger log = LoggerFactory.getLogger(CartServiceUserImpl.class);

	@Autowired
	private CartRepository cartrepository;
	ModelMapper mapper = new ModelMapper();

	@Override
	public CartDto create(CartDto cartDto) {
		log.info("saving ItemPrice to database");
		try {
			CartEntity cartentity = mapper.map(cartDto, CartEntity.class);
			CartEntity createCart = cartrepository.save(cartentity);
			log.info("saving ItemPrice to database");
			cartDto = mapper.map(createCart, CartDto.class);

			return cartDto;
		} catch (Exception e) {
			log.info("error while creating object", e);

		}
		return null;

	}

	@Override
	public List<CartDto> getAll() {
		List<CartEntity> cart = cartrepository.findAll();
		List<CartDto> cartDtoList;
		cartDtoList = new ArrayList<>();
		for (CartEntity Cartentity : cart) {
			CartDto cartdto = mapper.map(Cartentity, CartDto.class);

			cartDtoList.add(cartdto);
		}
		return cartDtoList;

	}

	@Override
	public CartDto update(CartDto cartDto) {
		if (ObjectUtils.isEmpty(cartDto.getId())) {
			throw new ApiRuntimeException("itemPriceDto ID cannot be NULL or Empty to UpdateItem", "NOT_FOUND",
					HttpStatus.NOT_FOUND);
		}

		log.info("updating item {}", cartDto);
		CartEntity cartEntity = mapper.map(cartDto, CartEntity.class);

		cartrepository.save(cartEntity);
		log.info("Item updated successfully");

		CartDto updatedItemPriceDto;
		updatedItemPriceDto = mapper.map(cartEntity, CartDto.class);
		return updatedItemPriceDto;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			log.info("Deleting ItemDetails  for Id {}, ", id);
			CartDto cartDto = getById(id);
			CartEntity cartEntity = mapper.map(cartDto, CartEntity.class);
			cartrepository.delete(cartEntity);
			return true;
		} catch (Exception e) {
			log.error("Error while deleting item for Id : {}", id);
			throw new ApiRuntimeException("Error while deleting item for Id " + id, "INTERNAL_ERROR",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public CartDto getById(Long id) {
		log.info("Getting ItemDetails  for Id {}, ", id);
		Optional<CartEntity> cartEntityOptional;
		cartEntityOptional = cartrepository.findById(id);
		if (cartEntityOptional.isPresent()) {
			CartEntity cartEntity = cartEntityOptional.get();
			return mapper.map(cartEntity, CartDto.class);
		}
		log.error("Item not found for Id : {}", id);
		throw new ApiRuntimeException("Item Not Found for ID: " + id, "NOT_FOUND", HttpStatus.NOT_FOUND);
	}

}