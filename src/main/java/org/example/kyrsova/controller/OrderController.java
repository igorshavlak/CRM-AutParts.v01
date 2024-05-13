package org.example.kyrsova.controller;

import org.example.kyrsova.DTO.OrderDTO;
import org.example.kyrsova.DTO.OrderWithPartsDTO;
import org.example.kyrsova.model.Client;
import org.example.kyrsova.model.Order;
import org.example.kyrsova.service.AutoPartService;
import org.example.kyrsova.service.ClientService;
import org.example.kyrsova.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ClientService clientService;
    private final AutoPartService autoPartService;
    @Autowired
    public OrderController(OrderService orderService, ClientService clientService, AutoPartService autoPartService) {
        this.orderService = orderService;
        this.clientService = clientService;
        this.autoPartService = autoPartService;
    }
    @GetMapping("/getAllOrders")
    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orderDTOS = new ArrayList<OrderDTO>();
        List<Order> orders = orderService.getAllOrders();
        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.id = order.getId();
            orderDTO.status = order.getStatus();
            orderDTO.client_name = clientService.getClient(order.getClient_id()).getName();
            orderDTO.order_data = String.valueOf(order.getData());
            orderDTO.total_amount = order.getTotal();
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }
    @PostMapping("/createOrder")
    public String createOrder(@RequestBody OrderWithPartsDTO orderRequest) {
        int totalPrice = 0;
        List<Integer> partIds = new ArrayList<>();
        for (String str : orderRequest.products) {
            totalPrice += autoPartService.getPriceById(Integer.parseInt(str));
            partIds.add(Integer.parseInt(str));
        }
        orderService.insertOrder(new Order(Integer.parseInt(orderRequest.client), orderRequest.status, Date.valueOf(orderRequest.date), totalPrice, partIds));
        Client client = clientService.getClient(Integer.parseInt(orderRequest.client));
        client.increaseOrder_quantity();
        clientService.updateClient(client);
        return "Ok!";
    }
    @PutMapping("/updateOrder")
    public String updateOrderStatus(@RequestParam String id,
                                    @RequestParam String client,
                                    @RequestParam String status,
                                    @RequestParam String date) {
        orderService.updateOrder(new Order(Integer.parseInt(id),Integer.parseInt(client), status, Date.valueOf(date)));
        return "Order updated!";
    }
    @DeleteMapping("/deleteOrder")
    public void deleteOrder(@RequestParam("id") String id) {
        orderService.deleteOrder(Integer.parseInt(id));
    }
}
