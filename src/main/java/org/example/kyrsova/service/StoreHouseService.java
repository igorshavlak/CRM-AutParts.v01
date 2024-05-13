package org.example.kyrsova.service;

import org.example.kyrsova.model.StoreHouse;
import org.example.kyrsova.repository.AutoPartRepository;
import org.example.kyrsova.repository.StoreHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreHouseService {
    StoreHouseRepository storeHouseRepository;
    @Autowired
    public StoreHouseService(StoreHouseRepository storeHouseRepository) {
        this.storeHouseRepository = storeHouseRepository;
    }
    public List<String> getAllStoreHouseNames(){
        return storeHouseRepository.getAllStoreHouseNames();
    }
    public int getStoreHouseIdByName(String storeHouseName){
        return storeHouseRepository.getStoreHouseIdByName(storeHouseName);
    }
   public String getStoreHouseNameById(int storeHouseId){
        return storeHouseRepository.getStoreHouseNameById(storeHouseId);
   }

}
