package com.myntra.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {
	private Long id;
	private String itemName;
	private int itemCost;
	private int quantity;


}
