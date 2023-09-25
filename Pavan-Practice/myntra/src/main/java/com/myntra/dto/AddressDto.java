package com.myntra.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
	private long Id;

	private String street;

	private String state;

	private int pinCode;

	private String city;
	
	private UserDto userDto;


}
