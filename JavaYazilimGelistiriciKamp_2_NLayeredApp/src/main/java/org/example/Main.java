package org.example;

import org.example.business.ProductManager;
import org.example.core.logging.DBLogger;
import org.example.core.logging.FileLogger;
import org.example.core.logging.Logger;
import org.example.dataAccess.HibernateProductDao;
import org.example.dataAccess.JdbcProductDao;
import org.example.entities.Product;

public class Main {
    public static void main(String[] args) throws Exception {
        Product product1 = new Product(1,"Iphone X",9000);
        Logger [] loggers = {new DBLogger(), new FileLogger()};
        ProductManager productManager = new ProductManager(new JdbcProductDao(), loggers);
        productManager.add(product1);


    }
}