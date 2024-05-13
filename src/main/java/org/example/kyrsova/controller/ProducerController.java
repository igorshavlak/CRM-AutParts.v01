package org.example.kyrsova.controller;

import org.example.kyrsova.service.ProducerService;
import org.example.kyrsova.service.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/producer")
public class ProducerController {
    public ProducerService producerService;

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;

    }
    @GetMapping("/getAllProducersNames")
    public List<String> getAllProducersNames(){
        return producerService.getAllProducersNames();

    }
}
