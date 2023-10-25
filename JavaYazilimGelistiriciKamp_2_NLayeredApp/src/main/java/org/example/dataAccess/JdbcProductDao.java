package org.example.dataAccess;

import org.example.entities.Product;

public class JdbcProductDao implements ProductDao {
    // You've to write only DB access codes in here
    public void add (Product product) {
        System.out.println("Data added to DB with JDBC");
    };
}
