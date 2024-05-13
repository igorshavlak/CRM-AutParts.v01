package org.example.kyrsova.controller;

import org.example.kyrsova.model.Client;
import org.example.kyrsova.model.Order;
import org.example.kyrsova.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/getAllClients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping("/addClient")
    public String addClient(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("address") String address,
                            @RequestParam("email") String email,
                            @RequestParam("phone") String phone) {
        clientService.saveClient(new Client(name, surname, address, email, phone));
        return "Client added";
    }

    @DeleteMapping("/deleteClient")
    public String deleteClient(@RequestParam("clientId") int id) {
        clientService.deleteClient(id);
        return "Client deleted";
    }

    @PutMapping("/updateClient")
    public String updateClient(@RequestParam("id") int id,
                               @RequestParam("name") String name,
                               @RequestParam("surname") String surname,
                               @RequestParam("address") String address,
                               @RequestParam("email") String email,
                               @RequestParam("phone") String phone) {

        clientService.updateClient(new Client(id,name,surname,address,phone,email,clientService.getClient(id).getOrder_quantity()));
        return "Client updated";
    }

}
