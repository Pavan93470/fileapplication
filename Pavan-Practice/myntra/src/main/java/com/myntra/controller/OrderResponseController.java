package com.myntra.controller;//package com.evoke.myntra.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.evoke.myntra.dto.OrderResponseDto;
//import com.evoke.myntra.service.OrderResponseService;
//
//@RestController
//@RequestMapping("/api")
//public class OrderResponseController {
//	private static final Logger log = LoggerFactory.getLogger(OrderResponseController.class);
//	@Autowired
//	private OrderResponseService orderResponseService;
//
//	@PostMapping("/orderstatus")
//	public ResponseEntity<OrderResponseDto> create(@RequestBody OrderResponseDto orderResponseDto) {
//		log.info("orderstatus saved successfully{}", orderResponseDto);
//		OrderResponseDto orderResponse = orderResponseService.create(orderResponseDto);
//
//		return new ResponseEntity<OrderResponseDto>(orderResponse, HttpStatus.CREATED);
//
//	}
//
//	@GetMapping("/orderstatus")
//	public ResponseEntity<List<OrderResponseDto>> getOrders() {
//		List<OrderResponseDto> orderCreationDtos = orderResponseService.getAll();
//		log.info("Get order");
//		return new ResponseEntity<List<OrderResponseDto>>(orderCreationDtos, HttpStatus.OK);
//	}
//
//	@GetMapping("/orderstatus/{id}")
//	public ResponseEntity<OrderResponseDto> getById(@PathVariable("id") Long id) {
//		OrderResponseDto orderRequestById = orderResponseService.getById(id);
//		return new ResponseEntity<OrderResponseDto>(orderRequestById, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/orderstatus/{id}")
//	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
//		orderResponseService.delete(id);
//		return new ResponseEntity<String>("order Deleted Successfully", HttpStatus.OK);
//	}
//
//	@PutMapping("/orderstatus/{id}")
//	public ResponseEntity<String> update(@RequestBody OrderResponseDto orderResponseDto) {
//		orderResponseService.update(orderResponseDto);
//		return new ResponseEntity<String>("orderstatus updated Successfully", HttpStatus.OK);
//	}
//
//}
