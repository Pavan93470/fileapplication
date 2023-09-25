package com.myntra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderRequestEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	@Column(name = "item_id")
	private long itemId;
	@Column(name = "quantity_ordered")
	private int quantityOrdered;
	@Column(name = "cartid")
	private long cartid;


}