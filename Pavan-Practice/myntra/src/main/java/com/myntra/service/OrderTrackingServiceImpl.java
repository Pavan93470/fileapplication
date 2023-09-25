package com.myntra.service;


import com.myntra.dto.OrderTracking;
import com.myntra.entity.OrderTrackingEntity;
import com.myntra.repository.OrderTrackingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderTrackingServiceImpl implements OrderTrackingService {
	@Autowired
	private OrderTrackingRepository orderTrackingRepository;
	ModelMapper mapper = new ModelMapper();

	@Override
	public OrderTracking create(OrderTracking OrderTracking) {
		OrderTrackingEntity orderTrackingEntity = mapper.map(OrderTracking, OrderTrackingEntity.class);
		OrderTrackingEntity order = orderTrackingRepository.save(orderTrackingEntity);
		return mapper.map(order, OrderTracking.class);

	}

}
