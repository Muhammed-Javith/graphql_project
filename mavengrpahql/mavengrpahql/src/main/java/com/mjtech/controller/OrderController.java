package com.mjtech.controller;

import com.mjtech.entities.Order;
import com.mjtech.entities.User;
import com.mjtech.services.OrderService;
import com.mjtech.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    private OrderService orderService;
    private UserService userService;

    public OrderController(OrderService orderService,UserService userService) {
        this.orderService = orderService;
        this.userService = userService;

    }

    //create order api
    //@MutationMapping(name="createOrder")
    @MutationMapping
    public Order createOrder(@Argument String address, @Argument String orderDetail, @Argument int price, @Argument int userId) {
        User user = userService.getUser(userId);
        Order order = new Order();
        order.setAddress(address);
        order.setOrderDetail(orderDetail);
        order.setPrice(price);
        order.setUser(user);
        Order order1 = orderService.createOrder(order);
        return order1;
    }
    //get Orders
    @QueryMapping(name = "getOrders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    //get Single order;
    @QueryMapping
    public Order getOrder(@Argument int orderId) {
        return orderService.getOrder(orderId);
    }
    //delete order
    //@SchemaMapping(typeName = "Mutation", field="deleteOrder")
    @MutationMapping
    public boolean deleteOrder(@Argument int orderId) {
        return orderService.deleteOrder(orderId);
    }
}

