//package com.myntra.controller;
//
//
//import com.myntra.service.OrderRequestService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//
//@RestController
//@RequestMapping("/api")
//@Slf4j
//public class OrderRequestController {
//
//	@Autowired
//	private OrderRequestService orderRequestService;
//
//	@PostMapping("/orderitem")
//	public ResponseEntity<String> save(@RequestBody OrderRequestDto orderRequestDto) {
//		log.info("creating order {}", orderRequestDto);
//
//		orderRequestService.create(orderRequestDto);
//		return new ResponseEntity<String>("order created successfully", HttpStatus.CREATED);
//
//	}
//
//	@GetMapping("/orderitem")
//	public ResponseEntity<List<OrderRequestDto>> getOrders() {
//		List<OrderRequestDto> orderCreationDtos = orderRequestService.getAll();
//		log.info("Get order");
//		return new ResponseEntity<List<OrderRequestDto>>(orderCreationDtos, HttpStatus.OK);
//	}
//
//	@GetMapping("/orderitem/{id}")
//	public ResponseEntity<OrderRequestDto> getById(@PathVariable("id") Long id) {
//		OrderRequestDto orderRequestById = orderRequestService.getById(id);
//		return new ResponseEntity<OrderRequestDto>(orderRequestById, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/orderitem/{id}")
//	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
//		orderRequestService.delete(id);
//		return new ResponseEntity<String>("order Deleted Successfully", HttpStatus.OK);
//	}
//
//}
