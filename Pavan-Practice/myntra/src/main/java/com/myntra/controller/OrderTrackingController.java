package com.myntra.controller;


import com.myntra.dto.OrderTracking;
import com.myntra.service.OrderTrackingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderTrackingController {
	private static final Logger log = LoggerFactory.getLogger(OrderTrackingController.class);

	@Autowired
	private OrderTrackingService orderTrackingService;

	@PostMapping("/ordertracking")
	public ResponseEntity<String> save(@RequestBody OrderTracking orderTracking) {
		log.info("Order Tracking {}", orderTracking);

		orderTrackingService.create(orderTracking);
		return new ResponseEntity<String>("order Delivered successfully", HttpStatus.CREATED);

	}
}
