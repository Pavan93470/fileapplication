package com.myntra.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item_price")
@Getter
@Setter
public class PriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "price")
	private double price;

	@Column(name = "discount_percentage")
	private double discountPercentage;

	@Column(name = "discount_amount")
	private double discountAmount;

	@Column(name = "net_amount")
	private double netAmount;


	@OneToOne(mappedBy = "itemPrice")
	private ItemEntity item;




}
