package com.myntra.dto;

import com.myntra.entity.OrderTrackingEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderTracking {
	private long id;
	private long orderid;
	private String orderedDate;

	private OrderTrackingEntity orderTrackingEntity;


}
