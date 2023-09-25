package com.myntra.service;


import com.myntra.dto.OrderInputDto;
import com.myntra.dto.OrderItemDto;
import com.myntra.dto.OrderResponseDto;
import com.myntra.entity.*;
import com.myntra.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderResponseRepository orderResponseRepository;

	@Override
	public OrderResponseDto create(OrderInputDto orderInputDto) {
		List<OrderItemDto> orderItemDtos = orderInputDto.getOrderItemDtos();

		double totalOrderCost = 0;
		int totalorderedquantity = 0;
		List<ItemEntity> itemEntities = new ArrayList<>();
		for (OrderItemDto orderItemDto : orderItemDtos) {
			int orderQuantity = orderItemDto.getOrderedQuantity();
			totalorderedquantity = totalorderedquantity + orderQuantity;
			Long itemId = (long) orderItemDto.getItemId();
			Optional<ItemEntity> itemEntityOptional = itemRepository.findById(itemId);
			if (itemEntityOptional.isPresent()) {
				ItemEntity itemEntity = itemEntityOptional.get();
				PriceEntity itemPriceEntity = itemEntity.getItemPrice();
				if (itemPriceEntity != null) {
					double discountPercentage = itemPriceEntity.getDiscountPercentage();
					double discountamount = (itemPriceEntity.getPrice() * discountPercentage) / 100;
					double netAmount = itemPriceEntity.getPrice() - discountamount;
					totalOrderCost = totalOrderCost + netAmount;
					itemEntity.setAvailableQuantity(itemEntity.getQuantity() - orderQuantity);
					itemEntity.getQuantity();

					itemEntities.add(itemEntity);
				}
			}

		}

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderCost(totalOrderCost);
		orderEntity.setStatus("OrderPlaced successfully");
		orderEntity.setDelieveryDate(new Date());

		Optional<UserEntity> userOptional = userRepository.findById(orderInputDto.getUserId());
		if (userOptional.isPresent()) {
			UserEntity userEntity = userOptional.get();
			orderEntity.setUser(userEntity);
			List<AddressEntity> addressEntities = userEntity.getAddress();
			if (!CollectionUtils.isEmpty(addressEntities)) {
				orderEntity.setAddress(addressEntities.get(0));
			}
		}

		OrderEntity newOrder = orderRepository.save(orderEntity);
		if (newOrder != null) {

			OrderResponseEntity orderResponseEntity = new OrderResponseEntity();
			orderResponseEntity.setOrderId(newOrder);
			orderResponseEntity.setItemEntity(itemEntities);
			orderResponseEntity.setQuantityOrdered(totalorderedquantity);

			orderResponseRepository.save(orderResponseEntity);
			ModelMapper mapper = new ModelMapper();
			OrderResponseDto orderResponseDto = mapper.map(orderResponseEntity, OrderResponseDto.class);

			return orderResponseDto;
		}
		return null;

	}

}
