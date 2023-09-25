package com.myntra.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OrderInputDto {

	private List<OrderItemDto> orderItemDtos;
	private long userId;


}
