package org.example.kyrsova.service;

import org.example.kyrsova.model.Producer;
import org.example.kyrsova.repository.AutoPartRepository;
import org.example.kyrsova.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProducerService {
    ProducerRepository producerRepository;

    @Autowired
    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }
    public List<String> getAllProducersNames() {
        return producerRepository.getAllProducers();
    }
    public int getProducerIdByName(String producerName) {
        return producerRepository.getProducerIdByName(producerName);
    }
   public String getProducerNameById(int producerId) {
        return producerRepository.getProducerNameById(producerId);
   }
}
