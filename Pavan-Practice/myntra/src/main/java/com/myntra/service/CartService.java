package com.myntra.service;


import com.myntra.dto.CartDto;

import java.util.List;

public interface CartService {
	CartDto create(CartDto cartDto);

	List<CartDto> getAll();

	CartDto update(CartDto cartDto);

	Boolean delete(Long id);

	CartDto getById(Long id);

}
