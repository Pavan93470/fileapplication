package com.myntra.service;


import com.myntra.dto.OrderInputDto;
import com.myntra.dto.OrderResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
	 OrderResponseDto create(OrderInputDto orderInputDto);

}
