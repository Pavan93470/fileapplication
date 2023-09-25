package com.myntra.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_details")
@Setter
@Getter
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "phonenumber")
	private long phonenumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_cart_id", referencedColumnName = "id")
	private CartEntity cartEntity;
	@OneToMany(mappedBy = "user")
	private List<AddressEntity> address;
	@OneToOne(mappedBy = "user")
	private OrderEntity order;


}
