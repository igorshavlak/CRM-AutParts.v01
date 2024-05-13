package org.example.kyrsova.repository;

import org.example.kyrsova.model.AutoPart;
import org.example.kyrsova.model.Category;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CategoryRepository {
    final String get_category_id_by_name = "select category_id from categories where category_name=?";
    final String get_all_category_names = "select category_name from categories";
    final String get_category_name_by_id = "select category_name from categories where category_id=?";

    JdbcTemplate jdbcTemplate;
    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getCategoryIdByName(String name) {
        return jdbcTemplate.queryForObject(get_category_id_by_name, Integer.class, name);
    }
    public List<String> getAllCategoriesNames() {
        return jdbcTemplate.query(get_all_category_names, (rs, rowNum) -> new String(
                rs.getString("category_name")

        ));
    }
    public String getCategoryNameById(int id) {
        return jdbcTemplate.queryForObject(get_category_name_by_id, String.class, id);
    }
}
