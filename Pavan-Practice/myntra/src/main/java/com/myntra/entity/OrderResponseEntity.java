
package com.myntra.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orderResponse")
@Setter
@Getter
public class OrderResponseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_response_id", referencedColumnName = "id")
	private OrderEntity orderId;
	@Column(name = "quantityOrdered")
	private int quantityOrdered;

	@OneToMany(mappedBy = "orderResponseEntity")
	private List<ItemEntity> itemEntity;


}
