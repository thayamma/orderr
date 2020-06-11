package com.infosys.project2.Controller;




import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.infosys.project2.Service.OrderService;



import com.infosys.project2.DTO.OrderDTO;
import com.infosys.project2.DTO.ProductOrderDTO;




@RestController
@RequestMapping(value="/order")
@EnableAutoConfiguration
@CrossOrigin
public class OrderController {
	@Autowired
	public OrderService orderservice;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value="/view", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDTO> getorders(){
		List<OrderDTO> orderDto=orderservice.getorders();
		return orderDto;
		}

	@GetMapping(value="/view/{orderid}", produces= MediaType.APPLICATION_JSON_VALUE)
	public OrderDTO getordersbyid(@PathVariable Integer orderid){
		logger.info("Request for Order view by Buyer {}", orderid);
		OrderDTO orderDto=orderservice.getordersbyid(orderid);
		return orderDto;
		}
	
	@GetMapping(value="/productview", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<ProductOrderDTO> getproductorders(){
		List<ProductOrderDTO> orderDto=orderservice.getproductorders();
		return orderDto;
		}
	
	@GetMapping(value="/productview/{orderid}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ProductOrderDTO getprodordersbyid(@PathVariable Integer orderid){
		logger.info("Request for Product Ordered view by Buyer {}", orderid);
		ProductOrderDTO orderDto=orderservice.getprodordersbyid(orderid);
		return orderDto;
		}
	
	@DeleteMapping(value="/remove/{orderid}", consumes= MediaType.APPLICATION_JSON_VALUE)
	public String removeorder(@PathVariable Integer orderid) {
		logger.info("Request for order removal by buyer {}", orderid);
		orderservice.removeorder(orderid);
		return "Deleted successfully";
		
		
	} 
	
	
}
	