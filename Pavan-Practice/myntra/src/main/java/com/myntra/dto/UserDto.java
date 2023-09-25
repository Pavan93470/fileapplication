package com.myntra.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private Long id;
	private String name;
	private String email;
	private long phonenumber;
	private AddressDto addressDto;
	private CartDto cartDto;


}
