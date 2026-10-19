package com.learning.ecommerceApplication.repositories;

import com.learning.ecommerceApplication.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * from orders WHERE user_id = :userId", nativeQuery = true )
    List<Order> findAllOrderByUserId(@Param("userId") Integer userId);

}
