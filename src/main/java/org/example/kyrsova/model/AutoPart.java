package org.example.kyrsova.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class AutoPart {
    private int part_id;
    private String part_name;
    private String part_desc;
    private byte[] part_image;
    private int part_producer_id;
    private int category_id;
    private int part_price;
    private int purchase_price;
    private int count;
    private int storage_house_id;
    private int sales;


    public AutoPart(int id,String part_name,String part_desc,
                    byte[] part_image, int part_producer_id,
                    int category_id,int part_price,int storage_house_id,
                    int purchase_price,
                    int count,int sales) {
        this.part_id = id;
        this.part_name = part_name;
        this.part_desc = part_desc;
        this.part_image = part_image;
        this.part_producer_id = part_producer_id;
        this.category_id = category_id;
        this.part_price = part_price;
        this.storage_house_id = storage_house_id;
        this.purchase_price = purchase_price;
        this.count = count;
        this.sales = sales;



    }
    public AutoPart(String part_name,String part_desc,
                    byte[] part_image, int part_producer_id, int category_id,
                    int part_price,int storage_house_id, int purchase_price,
                    int count,int sales) {
        this.part_name = part_name;
        this.part_desc = part_desc;
        this.part_image = part_image;
        this.part_producer_id = part_producer_id;
        this.category_id = category_id;
        this.part_price = part_price;
        this.storage_house_id = storage_house_id;
        this.purchase_price = purchase_price;
        this.count = count;
        this.sales = sales;

    }

    public int getPart_id() {
        return part_id;
    }
    public void setPart_id(int part_id) {
        this.part_id = part_id;
    }
    public String getPart_name() {
        return part_name;
    }
    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }
    public String getPart_desc() {
        return part_desc;
    }
    public void setPart_desc(String part_desc) {
        this.part_desc = part_desc;
    }
    public int getPart_price() {
        return part_price;
    }
    public void setPart_price(int part_price) {
        this.part_price = part_price;
    }
    public int getPurchase_price() {
        return purchase_price;
    }
    public void setPurchase_price(int purchase_price) {
        this.purchase_price = purchase_price;
    }
     public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public byte[] getPart_image() {
        return part_image;
    }
    public void setPart_image(byte[] part_image) {
        this.part_image = part_image;
    }
    public int getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    public int getStorage_house_id() {
        return storage_house_id;
    }
    public void setStorage_house_id(int storage_house_id) {
        this.storage_house_id = storage_house_id;
    }
    public void setPart_producer_id(int part_producer_id) {
        this.part_producer_id = part_producer_id;
    }

    public int getPart_producer_id() {
        return part_producer_id;
    }

    public int getSales() {
        return sales;
    }
}
