package com.myntra.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "orderCreation")
@Getter
@Setter
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	@Column(name = "status")
	private String status;
	@Column(name = "delieveryDate")
	private Date delieveryDate;
	@Column(name = "orderCost")
	private double orderCost;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_order_id", referencedColumnName = "id")
	private UserEntity user;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_address_id", referencedColumnName = "id")
	private AddressEntity address;
	@OneToOne(mappedBy = "orderEntity")
	private OrderTrackingEntity orderTrackingEntity;



}
