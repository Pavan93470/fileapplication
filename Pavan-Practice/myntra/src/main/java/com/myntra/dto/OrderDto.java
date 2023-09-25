package com.myntra.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
	private int id;
	private String status;
	private String delieveryDate;
	private double orderCost;
	private UserDto userId;
	private AddressDto addressId;


}
