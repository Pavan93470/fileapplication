package com.myntra.service;


import com.myntra.dto.PriceDto;

import java.util.List;

public interface PriceService {

	public PriceDto create(PriceDto item);

	public List<PriceDto> getAll();

	public PriceDto update(PriceDto PriceDto);

	public Boolean delete(Long id);

	public PriceDto getById(Long id);

}
