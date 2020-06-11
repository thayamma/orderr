package com.infosys.project2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.project2.Entity.OrderEntity;



@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {


	OrderEntity getOne(Integer orderId);

	
	OrderEntity findByOrderId(Integer orderId);
	

}
