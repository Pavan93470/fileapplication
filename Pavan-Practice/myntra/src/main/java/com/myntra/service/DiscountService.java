package com.myntra.service;


import com.myntra.dto.DiscountDto;

import java.util.List;

public interface DiscountService {
	 DiscountDto create(DiscountDto discont);

	 List<DiscountDto> getAll();

	 DiscountDto update(DiscountDto DiscountDto);

	 Boolean delete(Long id);

	 DiscountDto getById(Long id);

}
