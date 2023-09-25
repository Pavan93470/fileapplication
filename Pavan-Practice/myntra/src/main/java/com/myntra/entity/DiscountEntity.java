package com.myntra.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "discount")
@Getter
@Setter
public class DiscountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "totalCost")
	private float totalCost;
	@Column(name = "costToPaid")
	private float costToPaid;
	@Column(name = "discount")
	private float discount;


}
