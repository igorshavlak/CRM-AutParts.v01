package org.example.kyrsova.model;

import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

import java.sql.Date;
import java.util.List;


public class Order {
    private int id;
    private int client_id;
    private String status;
    private Date data;
    private int total;
    private List<Integer> partIds;

    public Order(int id, int client_id, String status, Date data, int total) {
        this.id = id;
        this.client_id = client_id;
        this.status = status;
        this.data = data;
        this.total = total;

    }
    public Order(int client_id, String status, Date data, int total,List<Integer> partIds) {
        this.client_id = client_id;
        this.status = status;
        this.data = data;
        this.total = total;
        this.partIds = partIds;

    }
    public Order(int id, int client_id, String status, Date data) {
        this.id = id;
        this.client_id = client_id;
        this.status = status;
        this.data = data;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getClient_id() {
        return client_id;
    }
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    public List<Integer> getPartIds() {
        return partIds;
    }


    public void setPartIds(List<Integer> partIds) {
        this.partIds = partIds;
    }
}
