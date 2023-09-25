package com.myntra.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscountDto {
	private long id;
	private float totalCost;
	private float costToPaid;
	private float discount;


}
