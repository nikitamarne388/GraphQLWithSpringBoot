package com.learning.ecommerceApplication.controller;

import com.learning.ecommerceApplication.dto.OrderInput;
import com.learning.ecommerceApplication.dto.UpdateOrderInput;
import com.learning.ecommerceApplication.entities.Order;
import com.learning.ecommerceApplication.entities.User;
import com.learning.ecommerceApplication.services.OrderService;
import com.learning.ecommerceApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @QueryMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @QueryMapping
    public Order getOrderById(@Argument Integer orderId) {
        return orderService.getOrderById(orderId);
    }

    @MutationMapping
    public Order createOrder(@Argument OrderInput input){
        Optional<User> user = userService.getUserById(input.getUserId());
        if(user.isPresent()){
            Order order = new Order(input.getOrderDetails(),input.getAddress(),input.getPrice(),user.get());
            System.out.println("Order created for user id : " + user.get().getUserId());
            return orderService.createOrder(order);
        }
        else{
            System.out.println("UserId " +input.getUserId() + " Not found in the System");
            return null;
        }
    }

    @MutationMapping
    public Order updateOrder(@Argument Integer orderId, @Argument UpdateOrderInput input) {
        Order orderToBeUpdated = orderService.getOrderById(orderId);
        if(input.getAddress() != null)
            orderToBeUpdated.setAddress(input.getAddress());
        return orderService.updateOrder(orderToBeUpdated);
    }

    @MutationMapping
    public Boolean deleteOrder(@Argument Integer orderId){
        return orderService.deleteOrder(orderId);
    }

    @QueryMapping
    public List<Order> getAllOrdersByUserId(@Argument Integer userId){
        return orderService.getAllOrdersByUserId(userId);
    }
}
