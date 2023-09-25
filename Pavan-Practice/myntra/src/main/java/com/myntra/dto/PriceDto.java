package com.myntra.dto;


import com.myntra.entity.ItemEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceDto {

	private Long id;
	private double price;
	private double discountAmount;
	private double discountPercentage;

	private ItemEntity item;


}
