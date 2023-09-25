package com.myntra.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item")
@Getter
@Setter

public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "category")
	private String category;

	@Column(name = "color")
	private String color;

	@Column(name = "brand")
	private String brand;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "available_qty")
	private int availableQuantity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_price_id", referencedColumnName = "id")
	private PriceEntity itemPrice;
	@ManyToOne(fetch = FetchType.LAZY)
	private OrderResponseEntity orderResponseEntity;



}
