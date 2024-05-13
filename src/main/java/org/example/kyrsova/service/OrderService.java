package org.example.kyrsova.service;

import org.example.kyrsova.model.Order;
import org.example.kyrsova.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    
    private OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
    public void insertOrder(Order order) {
        orderRepository.insertOrder(order);
    }
    public void updateOrder(Order order) {
        orderRepository.updateOrder(order);
    }
    public void deleteOrder(int id) {
        orderRepository.deleteOrder(id);
    }




}
