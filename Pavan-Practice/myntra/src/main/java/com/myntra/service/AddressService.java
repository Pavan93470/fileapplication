package com.myntra.service;


import com.myntra.dto.AddressDto;

import java.util.List;

public interface AddressService {
	AddressDto create(AddressDto address);

	List<AddressDto> getAll();

	AddressDto update(AddressDto AddressDto);

	Boolean delete(Long id);

	AddressDto getById(Long id);

}
