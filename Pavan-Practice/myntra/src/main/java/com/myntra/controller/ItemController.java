package com.myntra.controller;


import com.myntra.dto.ItemDto;
import com.myntra.dto.ItemPriceDto;
import com.myntra.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class ItemController {


	@Autowired
	private ItemService itemService;

	@PostMapping("/items")
	public ResponseEntity<ItemDto> saveItems(@RequestBody ItemDto itemDto) {
		log.info("creating item {}", itemDto);

		ItemDto newItemDto = itemService.create(itemDto);
		return new ResponseEntity<ItemDto>(newItemDto, HttpStatus.CREATED);

	}

	@GetMapping("/items")
	public ResponseEntity<List<ItemDto>> getItems(ItemDto item) {
		List<ItemDto> items = itemService.getAll();
		return new ResponseEntity<List<ItemDto>>(items, HttpStatus.OK);
	}

	@GetMapping("/items/{id}")
	public ResponseEntity<ItemDto> getById(@PathVariable("id") Long id) {
		ItemDto item = itemService.getById(id);
		return new ResponseEntity<ItemDto>(item, HttpStatus.OK);
	}

	@DeleteMapping("/items/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		itemService.delete(id);
		return new ResponseEntity<String>("Item Deleted Successfully", HttpStatus.OK);
	}

	@PutMapping("/items/price")
	public ResponseEntity<ItemDto> assignPrice(@RequestBody ItemPriceDto ItemPriceDto) {
		ItemDto itemDto = itemService.assignPriceToItem(ItemPriceDto.getItemId(), ItemPriceDto.getPriceId());
		return new ResponseEntity<ItemDto>(itemDto, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemDto> updateProduct(@PathVariable Long id, @RequestBody ItemDto itemDto) {

		ItemDto item = itemService.updateProduct(itemDto, id);
		return new ResponseEntity<ItemDto>(item, HttpStatus.OK);

	}
}
