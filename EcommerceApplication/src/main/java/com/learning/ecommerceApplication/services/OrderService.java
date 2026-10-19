package com.learning.ecommerceApplication.services;

import com.learning.ecommerceApplication.entities.Order;
import com.learning.ecommerceApplication.exceptions.ResourceNotFoundException;
import com.learning.ecommerceApplication.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    //create order
    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    //get all orders
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    //get order by ID
    public Order getOrderById(Integer orderId){
        return orderRepo.findById(orderId).orElseThrow(ResourceNotFoundException::throwResourceNotFoundException);
    }

    //Delete order
    public boolean deleteOrder(Integer orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(ResourceNotFoundException::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }

    //Update Order details
    public Order updateOrder(Order order) {
        return orderRepo.save(order);
    }

    //GetAllOrderByUserId
    public List<Order> getAllOrdersByUserId(Integer userId) {
        System.out.println("Finding Orders associated with a user...");
        return orderRepo.findAllOrderByUserId(userId);
    }
}
