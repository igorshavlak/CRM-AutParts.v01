package org.example.kyrsova.repository;

import org.example.kyrsova.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreHouseRepository {
    final String get_store_house_id_by_name = "select id from storeHouses where name=?";
    final String get_all_store_house_names = "select name from StoreHouses";
    final String get_store_house_name_by_id = "select name from StoreHouses where id=?";

    JdbcTemplate jdbcTemplate;
    public StoreHouseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getStoreHouseIdByName(String name) {
        return jdbcTemplate.queryForObject(get_store_house_id_by_name, Integer.class, name);
    }
    public List<String> getAllStoreHouseNames() {
        return jdbcTemplate.query(get_all_store_house_names, (rs, rowNum) -> new String(
                rs.getString("name")
        ));
    }
    public String getStoreHouseNameById(int id) {
        return jdbcTemplate.queryForObject(get_store_house_name_by_id, String.class, id);
    }
}
