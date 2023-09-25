package com.myntra.controller;


import com.myntra.dto.OrderInputDto;
import com.myntra.dto.OrderResponseDto;
import com.myntra.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class OrderManagementController {
	@Autowired
	private OrderService orderService;



	@PostMapping("/order")
	public ResponseEntity<OrderResponseDto> create(@RequestBody OrderInputDto orderInputDto) {
		log.info("creating  {}", orderInputDto);

		orderService.create(orderInputDto);
		return new ResponseEntity<OrderResponseDto>(HttpStatus.CREATED);

	}
}