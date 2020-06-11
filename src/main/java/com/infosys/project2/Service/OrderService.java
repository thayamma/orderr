package com.infosys.project2.Service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.project2.DTO.OrderDTO;
import com.infosys.project2.DTO.ProductOrderDTO;
import com.infosys.project2.Entity.OrderEntity;
import com.infosys.project2.Entity.ProductOrderEntity;
import com.infosys.project2.Repository.OrderRepository;
import com.infosys.project2.Repository.ProductOrderRepository;
@Service
public class OrderService {
	
	@Autowired
	OrderRepository order;

	@Autowired
	ProductOrderRepository orders;
	

	public List<OrderDTO> getorders() {
		List<OrderDTO> l=new ArrayList<OrderDTO>();
		List<OrderEntity> oe=order.findAll();
		for(OrderEntity o: oe) {
		OrderDTO O=OrderDTO.valueof(o);
		l.add(O);
		}
		return l;
	}


	public OrderDTO getordersbyid(Integer id) {
		OrderEntity oe=order.getOne(id);
		OrderDTO O=OrderDTO.valueof(oe);
		return O;
	}


	public List<ProductOrderDTO> getproductorders() {
		List<ProductOrderDTO> l=new ArrayList<ProductOrderDTO>();
		List<ProductOrderEntity> oe=orders.findAll();
		for(ProductOrderEntity o: oe) {
		ProductOrderDTO O=ProductOrderDTO.valueof(o);
		l.add(O);
		}
		return l;
	}


	public ProductOrderDTO getprodordersbyid(Integer orderId) {
		ProductOrderEntity oe=orders.getOne(orderId);
		ProductOrderDTO O=ProductOrderDTO.valueof(oe);
		return O;
	}


	public void removeorder(Integer orderId) {
		OrderEntity oe=order.findByOrderId(orderId);
		order.delete(oe);
		
	}
	}
		
	