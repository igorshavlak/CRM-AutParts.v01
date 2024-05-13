package org.example.kyrsova.service;

import org.example.kyrsova.model.Client;
import org.example.kyrsova.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public Client getClient(int id) {
        return clientRepository.getClientById(id);
    }
    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }
    public void saveClient(Client client) {
        clientRepository.save(client);
    }
    public void  updateClient(Client client) {
        clientRepository.update(client);
    }
    public void deleteClient(int id) {
        clientRepository.delete(id);
    }

}
