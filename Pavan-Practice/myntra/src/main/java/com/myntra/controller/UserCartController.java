package com.myntra.controller;


import com.myntra.dto.CartDto;
import com.myntra.dto.UserDto;
import com.myntra.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserCartController {
	private static final Logger log = LoggerFactory.getLogger(UserCartController.class);

	@Autowired
	private CartService cartService;

	@PostMapping("/cart")
	public ResponseEntity<CartDto> saveItems(@RequestBody CartDto cartDto) {
		log.info("items created successfully{}", cartDto);
		CartDto newCartDto = cartService.create(cartDto);

		return new ResponseEntity<CartDto>(newCartDto, HttpStatus.CREATED);
	}

	@GetMapping("/cart")
	public ResponseEntity<List<CartDto>> getItems(CartDto cart) {
		List<CartDto> cartDto = cartService.getAll();
		return new ResponseEntity<List<CartDto>>(cartDto, HttpStatus.OK);
	}

	@GetMapping("/cart/{id}")
	public ResponseEntity<UserDto> getById(@PathVariable("id") Long id) {
		CartDto users = cartService.getById(id);
		return new ResponseEntity<UserDto>(HttpStatus.OK);
	}

	@DeleteMapping("/cart/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		cartService.delete(id);
		return new ResponseEntity<String>("Item Deleted Successfully", HttpStatus.OK);
	}

}
