package com.myntra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "cart_items")
@Getter
@Setter
public class CartEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "itemName")
	private String itemName;
	@Column(name = "itemCost")
	private int itemCost;
	@Column(name = "quantity")
	private int quantity;

	@OneToOne(mappedBy = "cartEntity")
	private UserEntity UserEntity;



}
