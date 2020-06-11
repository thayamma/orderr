package com.infosys.project2.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.infosys.project2.Entity.ProductOrderEntity;



@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrderEntity, Integer> {

	ProductOrderEntity getOne(Integer orderId);

	ProductOrderEntity findByOrderId(Integer orderId);




//	Optional<ProductOrderEntity> findAllById(Integer orderId);
	

}
