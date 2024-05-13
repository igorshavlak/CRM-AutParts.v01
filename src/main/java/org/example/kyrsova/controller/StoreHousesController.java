package org.example.kyrsova.controller;

import org.example.kyrsova.service.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/storeHouse")
public class StoreHousesController {
    public StoreHouseService storeHouseService;

    @Autowired
    public StoreHousesController(StoreHouseService storeHouseService) {
        this.storeHouseService = storeHouseService;

    }
    @GetMapping("/getAllStoreHouseNames")
    public List<String> getAllStoreHouseNames(){
        return storeHouseService.getAllStoreHouseNames();
    }

}
