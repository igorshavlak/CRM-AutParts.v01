package org.example.kyrsova.repository;

import org.example.kyrsova.model.Category;
import org.example.kyrsova.model.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProducerRepository {
    JdbcTemplate jdbcTemplate;
    final String get_producer_id_by_name = "select id from producers where name=?";
    final String get_all_producer_names = "select name from Producers" ;
    final String get_producer_name_by_id = "select name from producers where id=?";

    @Autowired
    public ProducerRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int getProducerIdByName(String name) {
        return jdbcTemplate.queryForObject(get_producer_id_by_name, Integer.class, name);
    }
    public List<String> getAllProducers() {
        return jdbcTemplate.query(get_all_producer_names, (rs, rowNum) -> new String(
                rs.getString("name")
        ));
    }
    public String getProducerNameById(int id) {
        return jdbcTemplate.queryForObject(get_producer_name_by_id, String.class, id);
    }



}
