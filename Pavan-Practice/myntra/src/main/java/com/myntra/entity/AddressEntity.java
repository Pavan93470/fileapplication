package com.myntra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "address")
@Getter
@Setter
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	@Column(name = "street")
	private String street;
	@Column(name = "state_name")
	private String state;
	@Column(name = "pinCode")
	private int pinCode;
	@Column(name = "city")
	private String city;
	@ManyToOne(fetch = FetchType.LAZY)
	private UserEntity user;
	@OneToOne(mappedBy = "address")
	private OrderEntity order;


}