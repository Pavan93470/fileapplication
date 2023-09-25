package com.myntra.controller;


import com.myntra.dto.AddressDto;
import com.myntra.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@Slf4j
public class AddressController {


	@Autowired
	AddressService addressService;

	@PostMapping("/address")
	public ResponseEntity<AddressDto> create(@RequestBody AddressDto addressDto) {
		log.info("Address saved successfully{}", addressDto);
		AddressDto address = addressService.create(addressDto);

		return new ResponseEntity<AddressDto>(address, HttpStatus.CREATED);

	}

	@GetMapping("/address")
	public ResponseEntity<List<AddressDto>> getall() {
		log.info("Get address");
		List<AddressDto> address = addressService.getAll();
		return new ResponseEntity<List<AddressDto>>(address, HttpStatus.OK);

	}

	@GetMapping("/address/{id}")
	public ResponseEntity<AddressDto> getById(@PathVariable("id") Long id) {
		AddressDto address = addressService.getById(id);
		return new ResponseEntity<AddressDto>(address, HttpStatus.OK);
	}

	@DeleteMapping("/address/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		addressService.delete(id);
		return new ResponseEntity<String>("Address Deleted Successfully", HttpStatus.OK);
	}

	@PutMapping("/address/{id}")
	public ResponseEntity<String> update(@RequestBody AddressDto address) {
		addressService.update(address);
		return new ResponseEntity<String>("Address updated Successfully", HttpStatus.OK);
	}

}
