package org.example.kyrsova.repository;


import org.example.kyrsova.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {

    JdbcTemplate jdbcTemplate;
    final String get_client_by_id = "select * from clients where id = ?";
    final String get_clients = "select * from clients";
    final String insert_client = "insert into clients (name, surname, email, phone, order_quantity) values (?,?,?,?,?)";
    final String update_client = "update clients set name=?, surname=?, address=?, email=?, phone=?, order_quantity=?" +
            " where id=?";
    final String delete_client = "delete from clients where id=?";
    @Autowired
    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Client getClientById(int id) {
        return jdbcTemplate.queryForObject(get_client_by_id,new Object[]{id}, (rs, rowNum) -> new Client(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("address"),
                rs.getString("phone"),
                rs.getString("email"),
                rs.getInt("order_quantity")
        ));
    }
    public List<Client> getAllClients() {
        return jdbcTemplate.query(get_clients, (rs, rowNum) -> new Client(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("address"),
                rs.getString("phone"),
                rs.getString("email"),
                rs.getInt("order_quantity")
        ));
    }
    public void save(Client client) {
        jdbcTemplate.update(insert_client, client.getName(),client.getSurname(),client.getEmail(),client.getPhone(),0);
    }
    public void update(Client client) {
        jdbcTemplate.update(update_client, client.getName(),client.getSurname(),client.getAddress(), client.getEmail(),client.getPhone(),client.getOrder_quantity(),client.getId());
    }
    public void delete(int id) {
        jdbcTemplate.update(delete_client, id);
    }
}
