package com.myntra.service;


import com.myntra.dto.PriceDto;
import com.myntra.entity.PriceEntity;
import com.myntra.exception.ApiRuntimeException;
import com.myntra.repository.PriceRepository;
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
public class PriceServiceImpl implements PriceService {
	private static final Logger log = LoggerFactory.getLogger(PriceService.class);

	@Autowired
	private PriceRepository itemRepository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public PriceDto create(PriceDto PriceDto) {
		log.info("saving ItemPrice to database");

		try {

			ModelMapper mapper = new ModelMapper();
			PriceEntity PriceEntity = mapper.map(PriceDto, PriceEntity.class);

			PriceEntity createdItem = itemRepository.save(PriceEntity);
			log.info("saved ItemPrice to database");
			PriceDto = mapper.map(createdItem, PriceDto.class);
			return PriceDto;

		} catch (Exception e) {
			log.error("error-saving ItemPrice to database: {}", e);
		}
		return null;
	}

	@Override
	public List<PriceDto> getAll() {
		List<PriceEntity> items = itemRepository.findAll();

		List<PriceDto> PriceDtosList = new ArrayList<>();

		for (PriceEntity PriceEntity : items) {

			PriceDto PriceDto = mapper.map(PriceEntity, PriceDto.class);

			PriceDtosList.add(PriceDto);

		}
		return PriceDtosList;
	}

	@Override
	public PriceDto update(PriceDto PriceDto) {
		if (StringUtils.isEmpty(PriceDto.getId())) {
			throw new ApiRuntimeException("PriceDto ID cannot be NULL or Empty to UpdateItem", "NOT_FOUND",
					HttpStatus.NOT_FOUND);
		}

		log.info("updating item {}", PriceDto.toString());
		PriceEntity PriceEntity = mapper.map(PriceDto, PriceEntity.class);

		itemRepository.save(PriceEntity);
		log.info("Item updated successfully");

		PriceDto updatedPriceDto = mapper.map(PriceEntity, PriceDto.class);
		return updatedPriceDto;
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
		Optional<PriceEntity> PriceEntityOptional = itemRepository.findById(id);
		if (PriceEntityOptional.isPresent()) {
			PriceEntity PriceEntity = PriceEntityOptional.get();
			PriceDto PriceDto = mapper.map(PriceEntity, PriceDto.class);
			return PriceDto;
		}
		log.error("Item not found for Id : {}", id);
		throw new ApiRuntimeException("Item Not Found for ID: " + id, "NOT_FOUND", HttpStatus.NOT_FOUND);
	}

}
