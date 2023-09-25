package com.myntra.service;


import com.myntra.dto.ItemDto;
import com.myntra.dto.PriceDto;
import com.myntra.entity.ItemEntity;
import com.myntra.entity.PriceEntity;
import com.myntra.exception.ApiRuntimeException;
import com.myntra.repository.ItemRepository;
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
public class ItemServiceImpl implements ItemService {
	private static final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private com.myntra.repository.PriceRepository PriceRepository;
	private ModelMapper mapper = new ModelMapper();

	@Override
	public ItemDto create(ItemDto itemDto) {
		log.info("saving items to database");

		try {

			ModelMapper mapper = new ModelMapper();
			ItemEntity itemEntity = mapper.map(itemDto, ItemEntity.class);

			ItemEntity createdItem = itemRepository.save(itemEntity);
			log.info("saved Item to database");
			itemDto = mapper.map(createdItem, ItemDto.class);
			return itemDto;

		} catch (Exception e) {
			log.error("error-saving item to database: {}", e);
		}
		return null;
	}

	@Override
	public List<ItemDto> getAll() {
		List<ItemEntity> items = itemRepository.findAll();

		List<ItemDto> itemDtosList = new ArrayList<>();

		for (ItemEntity itemEntity : items) {

			ItemDto itemDto = mapper.map(itemEntity, ItemDto.class);

			itemDtosList.add(itemDto);

		}
		return itemDtosList;
	}

	@Override
	public ItemDto update(ItemDto itemDto) {
		if (StringUtils.isEmpty(itemDto.getId())) {
			throw new ApiRuntimeException("Item ID cannot be NULL or Empty to UpdateItem", "NOT_FOUND",
					HttpStatus.NOT_FOUND);
		}

		log.info("updating item {}", itemDto.toString());
		ItemEntity itemEntity = mapper.map(itemDto, ItemEntity.class);

		itemRepository.save(itemEntity);
		log.info("Item updated successfully");

		ItemDto updatedItemDto = mapper.map(itemEntity, ItemDto.class);
		return updatedItemDto;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			log.info("Deleting ItemDetails  for Id {}, ", id);
			ItemDto itemDto = getById(id);
			ItemEntity itemEntity = mapper.map(itemDto, ItemEntity.class);
			itemRepository.delete(itemEntity);
			return true;
		} catch (Exception e) {
			log.error("Error while deleting item for Id : {}", id);
			throw new ApiRuntimeException("Error while deleting item for Id " + id, "INTERNAL_ERROR",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ItemDto getById(Long id) {
		log.info("Getting ItemDetails  for Id {}, ", id);
		Optional<ItemEntity> itemEntityOptional = itemRepository.findById(id);
		if (itemEntityOptional.isPresent()) {

			ItemEntity itemEntity = itemEntityOptional.get();
			ItemDto itemDto = mapper.map(itemEntity, ItemDto.class);

			PriceEntity PriceEntity = itemEntity.getItemPrice();
			if (PriceEntity != null) {
				PriceDto PriceDto = mapper.map(PriceEntity, PriceDto.class);
				itemDto.setPriceDto(PriceDto);
			}

			return itemDto;
		}
		log.error("Item not found for Id : {}", id);
		throw new ApiRuntimeException("Item Not Found for ID: " + id, "NOT_FOUND", HttpStatus.NOT_FOUND);
	}

	@Override
	public ItemDto assignPriceToItem(Long itemId, Long priceId) {

		ItemEntity itemEntity = itemRepository.findById(itemId).get();

		PriceEntity PriceEntity = PriceRepository.findById(priceId).get();

		itemEntity.setItemPrice(PriceEntity);

		itemRepository.save(itemEntity);

		ItemDto itemDto = mapper.map(itemEntity, ItemDto.class);

		PriceDto PriceDto = mapper.map(PriceEntity, PriceDto.class);

		itemDto.setPriceDto(PriceDto);

		return itemDto;
	}

	@Override
	public ItemDto updateProduct(ItemDto itemDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public ItemDto updateProduct(ItemDto itemDto, Long id) {
//		try {
//			ModelMapper mapper = new ModelMapper();
//			ItemEntity itemEntity = mapper.map(itemDto, ItemEntity.class);
//			itemRepository.findById(id).get();
//			itemEntity.setId(id);
//			itemEntity.setAvailableQuantity(itemDto.getAvailableQuantity());
//			itemEntity.setBrand(itemDto.getBrand());
//			itemEntity.setCategory(itemDto.getCategory());
//			itemEntity.setColor(itemDto.getColor());
//			itemEntity.setQuantity(itemDto.getQuantity());
//			itemEntity.setStock(itemDto.getStock());
//			itemEntity.setDescription(itemDto.getDescription());
//			itemEntity.setName(itemDto.getName());
//			itemEntity.setDescription(itemDto.getDescription());
//			ItemDto item = mapper.map(itemEntity, ItemDto.class);
//
//			return item;
//		}
//
//		catch (Exception e) {
//			log.error("Error while deleting item for Id : {}", id);
//			throw new ApiRuntimeException("Error while deleting item for Id " + id, "INTERNAL_ERROR",
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
}
