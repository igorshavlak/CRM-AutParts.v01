package org.example.kyrsova.DTO;

import java.time.LocalDate;
import java.util.List;

public class OrderWithPartsDTO{
    public int id;
    public String status;
    public String client;
    public LocalDate date;
    public List<String> products;
    public int amount;
}
