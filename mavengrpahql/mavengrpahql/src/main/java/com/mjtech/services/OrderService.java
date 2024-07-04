package com.mjtech.services;

import com.mjtech.entities.Order;
import com.mjtech.entities.User;
import com.mjtech.helper.ExceptionHelper;
import com.mjtech.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
    //create order
    public Order createOrder(Order order){
        return orderRepo.save(order);
    }
    //get all order
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }
    //get single
    public Order getOrder(int orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        return order;
    }
    //delete Order
    public boolean deleteOrder(int orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }
}
