package com.myntra.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class OrderResponseDto {
	private int orderId;
	private List<ItemDto> itemDtos;
	private AddressDto address;
	private UserDto userDto;
	private String status;
	private Date orderedDate;
	private Date delieveryDate;


}