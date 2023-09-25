package com.myntra.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {

	private Long id;
	private String name;
	private String description;
	private String category;
                          
	
	private String color;
	private String brand;
	private int quantity;
	private int availableQuantity;
	private PriceDto PriceDto;


}














