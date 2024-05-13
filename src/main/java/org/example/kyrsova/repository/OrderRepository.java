package org.example.kyrsova.repository;

import org.example.kyrsova.model.AutoPart;
import org.example.kyrsova.model.Client;
import org.example.kyrsova.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class OrderRepository {
    JdbcTemplate jdbcTemplate;
    final String get_all_orders = "select * from orders";
    final String insert_order = "insert into orders(client_id,status,total_amount,order_date) values(?,?,?,?)";
    final String insert_orders_parts = "insert into orderparts(order_id,auto_part_id) values(?,?)";
    final String get_parts_for_order = "select p.* from autoparts p join orderparts op ON p.id = op.part_id where p.order_id=?";
    final String update_order ="update orders set client_id=?, status=?, order_date=?" +
            " where id=?";
    private final String deleteOrder = "delete from orders where id=?";
    private final String deleteOrderParts = "delete from orderparts WHERE order_id=?";


    @Autowired
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> getAllOrders() {

        return jdbcTemplate.query(get_all_orders, (rs, rowNum) -> new Order(
                rs.getInt("id"),
                rs.getInt("client_id"),
                rs.getString("Status"),
                rs.getDate("order_date"),
                rs.getInt("total_amount")

        ));
    }

    public List<AutoPart> getAllOrdersParts(int id) {
        return jdbcTemplate.query(get_parts_for_order, new Object[]{id}, (rs, rowNum) -> new AutoPart(
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

    public void insertOrder(Order order) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insert_order, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getClient_id());
            ps.setString(2, order.getStatus());
            ps.setDouble(3, order.getTotal());
            ps.setDate(4, order.getData());

            return ps;
        }, keyHolder);

        Map<String, Object> keys = keyHolder.getKeys();
        if (keys != null) {
            int orderId = ((Number) keys.get("id")).intValue();

            for (int partId : order.getPartIds()) {
                jdbcTemplate.update(insert_orders_parts, orderId, partId);
            }

        }

    }
    public void updateOrder(Order order) {
            jdbcTemplate.update(update_order,order.getClient_id(),order.getStatus(),order.getData(),order.getId());
    }
    public void deleteOrder(int id) {
        jdbcTemplate.update(deleteOrderParts,id);
        jdbcTemplate.update(deleteOrder,id);
    }
}
