package org.example.kyrsova.repository;

import org.example.kyrsova.DTO.FilteredAutoPartDTO;
import org.example.kyrsova.model.AutoPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AutoPartRepository {

    JdbcTemplate jdbcTemplate;
    final String add_auto_part = "insert into autoparts(part_name,part_desc,part_producer_id," +
            "part_price,category_id,storage_house_id,purchase_price,part_image,count,sales) values(?,?,?,?,?,?,?,?,?,?)";
    final String update_auto_part = "UPDATE autoparts SET part_name=?, part_desc=?, part_producer_id=?, " +
            "part_price=?, category_id=?, storage_house_id=?, purchase_price=?, part_image=?, count=?, sales=? " +
            "WHERE part_id=?";
    final String get_part_names = "select part_name from autoparts";
    final String get_auto_part_by_id = "select * from autoparts where part_id=?";
    final String remove_auto_part_by_id = "delete from autoparts where part_id=?";
    final String get_all_auto_parts = "select * from autoparts";
    final String get_price_by_id = "select part_price from autoparts where part_id=?";
    final String get_id_by_name = "select part_id from autoparts where part_name=?";
    String get_filtered_auto_parts = "select * from autoparts where ";


    @Autowired
    public AutoPartRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getPriceById(int part_id) {
        return jdbcTemplate.queryForObject(get_price_by_id, Integer.class, part_id);

    }
    public int getIdByName(String name) {
        return jdbcTemplate.queryForObject(get_id_by_name, Integer.class, name);
    }

    public List<AutoPart> getFilteredParts(FilteredAutoPartDTO filteredAutoPartDTO) {
        List<Object> params = new ArrayList<>();

        if (filteredAutoPartDTO.category_id != 0) {
            get_filtered_auto_parts += "category_id = ? and ";
            params.add(filteredAutoPartDTO.category_id);
        }
        if (filteredAutoPartDTO.store_house_id != 0) {
            get_filtered_auto_parts += "storage_house_id = ? and ";
            params.add(filteredAutoPartDTO.store_house_id);
        }
        if (filteredAutoPartDTO.producer_id != 0) {
            get_filtered_auto_parts += "part_producer_id = ? and ";
            params.add(filteredAutoPartDTO.producer_id);
        }
        if (filteredAutoPartDTO.max_price != 0 && filteredAutoPartDTO.min_price != 0) {
            get_filtered_auto_parts += "part_price between ? and ? ";
            params.add(filteredAutoPartDTO.min_price);
            params.add(filteredAutoPartDTO.max_price);
        }
        if (get_filtered_auto_parts.endsWith("and ")) {
            get_filtered_auto_parts = get_filtered_auto_parts.substring(0, get_filtered_auto_parts.length() - 5);
        }
        String get_filtered_auto_parts_another = get_filtered_auto_parts;
        get_filtered_auto_parts = "select * from autoparts where ";
        return jdbcTemplate.query(get_filtered_auto_parts_another, params.toArray(), (rs, rowNum) -> new AutoPart(
                rs.getInt("part_id"),
                rs.getString("part_name"),
                rs.getString("part_desc"),
                rs.getBytes("part_image"),
                rs.getInt("part_producer_id"),
                rs.getInt("category_id"),
                rs.getInt("part_price"),
                rs.getInt("storage_house_id"),
                rs.getInt("purchase_price"),
                rs.getInt("count"),
                rs.getInt("sales")
        ));

    }

    public List<String> getPartNames() {
        return jdbcTemplate.query(get_part_names, (rs, rowNum) -> new String(
                rs.getString("part_name")

        ));
    }

    public void update(AutoPart autoPart) {
        jdbcTemplate.update(update_auto_part, autoPart.getPart_name(), autoPart.getPart_desc(), autoPart.getPart_producer_id(),
                autoPart.getPart_price(), autoPart.getCategory_id(), autoPart.getStorage_house_id(), autoPart.getPurchase_price(),
                autoPart.getPart_image(), autoPart.getCount(), autoPart.getSales(), autoPart.getPart_id());
    }

    public void addAutoPart(AutoPart autoPart) {
        jdbcTemplate.update(add_auto_part, autoPart.getPart_name(), autoPart.getPart_desc(), autoPart.getPart_producer_id(),
                autoPart.getPart_price(), autoPart.getCategory_id(), autoPart.getStorage_house_id(), autoPart.getPurchase_price(),
                autoPart.getPart_image(), autoPart.getCount(), autoPart.getSales());
    }

    public List<AutoPart> getAllAutoParts() {
        return jdbcTemplate.query(get_all_auto_parts, (rs, rowNum) -> new AutoPart(
                rs.getInt("part_id"),
                rs.getString("part_name"),
                rs.getString("part_desc"),
                rs.getBytes("part_image"),
                rs.getInt("part_producer_id"),
                rs.getInt("category_id"),
                rs.getInt("part_price"),
                rs.getInt("storage_house_id"),
                rs.getInt("purchase_price"),
                rs.getInt("count"),
                rs.getInt("sales")
        ));
    }

    public AutoPart getAutoPartById(int id) {
        return jdbcTemplate.queryForObject(get_auto_part_by_id, new Object[]{id}, (rs, rowNum) ->
                new AutoPart(
                        rs.getInt("part_id"),
                        rs.getString("part_name"),
                        rs.getString("part_desc"),
                        rs.getBytes("part_image"),
                        rs.getInt("part_producer_id"),
                        rs.getInt("category_id"),
                        rs.getInt("part_price"),
                        rs.getInt("storage_house_id"),
                        rs.getInt("purchase_price"),
                        rs.getInt("count"),
                        rs.getInt("sales")

                ));
    }

    public void removeAutoPartById(int id) {
        jdbcTemplate.update(remove_auto_part_by_id, id);
    }
}

