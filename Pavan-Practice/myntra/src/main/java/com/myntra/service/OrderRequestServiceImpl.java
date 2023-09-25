//package com.myntra.service;//package com.evoke.myntra.service;
//
//import com.myntra.entity.OrderRequestEntity;
//import com.myntra.exception.ApiRuntimeException;
//import com.myntra.repository.OrderRequestRepository;
//import org.modelmapper.ModelMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//public class OrderRequestServiceImpl implements OrderRequestService {
//	private static final Logger log = LoggerFactory.getLogger(OrderRequestServiceImpl.class);
//
//	@Autowired
//	private OrderRequestRepository orderRequestRepository;
//
//	ModelMapper mapper = new ModelMapper();
//
//	@Override
//	public OrderRequestDto create(OrderRequestDto order) {
//		try {
//			log.info("Address saved successfully");
//			OrderRequestEntity orderRequestEntity = mapper.map(order, OrderRequestEntity.class);
//			OrderRequestEntity orders = orderRequestRepository.save(orderRequestEntity);
//			OrderRequestDto orderRequestDto = mapper.map(orders, OrderRequestDto.class);
//			return orderRequestDto;
//		} catch (Exception e) {
//			log.error("", e);
//
//		}
//		return null;
//	}
//
//	@Override
//	public List<OrderRequestDto> getAll() {
//		List<OrderRequestEntity> order = orderRequestRepository.findAll();
//
//		List<OrderRequestDto> orderRequestDtosList = new ArrayList<>();
//
//		for (OrderRequestEntity orderRequestEntityRepository : order) {
//
//			OrderRequestDto orderRequestDto = mapper.map(orderRequestEntityRepository, OrderRequestDto.class);
//
//			orderRequestDtosList.add(orderRequestDto);
//
//		}
//		return orderRequestDtosList;
//	}
//
//	@Override
//	public Boolean delete(Long id) {
//		try {
//			log.info("Deleting ItemDetails  for Id {}, ", id);
//			OrderRequestDto orderRequest = getById(id);
//			OrderRequestEntity orderRequestEntity = mapper.map(orderRequest, OrderRequestEntity.class);
//			orderRequestRepository.delete(orderRequestEntity);
//			return true;
//		} catch (Exception e) {
//			log.error("Error while deleting order for Id : {}", id);
//			throw new ApiRuntimeException("Error while deleting  adress for Id " + id, "INTERNAL_ERROR",
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	@Override
//	public OrderRequestDto getById(Long id) {
//		log.info("Getting ItemDetails  for Id {}, ", id);
//		Optional<OrderRequestEntity> orderRequestEntityOptional = orderRequestRepository.findById(id);
//		if (orderRequestEntityOptional.isPresent()) {
//
//			OrderRequestEntity orderRequestEntity = orderRequestEntityOptional.get();
//			OrderRequestDto orderRequestDto = mapper.map(orderRequestEntity, OrderRequestDto.class);
//
//			return orderRequestDto;
//		}
//		log.error("order not found for Id : {}", id);
//		throw new ApiRuntimeException("order Not Found for ID: " + id, "NOT_FOUND", HttpStatus.NOT_FOUND);
//	}
//
//	@Override
//	public OrderRequestDto getPriceAfterDiscount(double price, double discountPercentage, long id) {
//		try {
//			log.info("DiscountAmount  {}, ", id);
//			OrderRequestDto OrderRequest = getById(id);
//			OrderRequestEntity orderRequestEntity = mapper.map(PriceDto, OrderRequestEntity.class);
//			double discountamount = (price * discountPercentage) / 100;
//			orderRequestEntity.setDiscountAmount(discountamount);
//			double netAmount = price - discountamount;
//			orderRequestEntity.setNetAmount(netAmount);
//
//			orderRequestRepository.save(PriceEntity);
//
//			OrderRequestDto orderRequestDto = mapper.map(orderRequestEntity, OrderRequestDto.class);
//
//			return orderRequestDto;
//		} catch (Exception e) {
//			log.error("Error while calculating discount amount : {}", id);
//			throw new ApiRuntimeException("Error while calculating discount amount" + id, "INTERNAL_ERROR",
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//}
