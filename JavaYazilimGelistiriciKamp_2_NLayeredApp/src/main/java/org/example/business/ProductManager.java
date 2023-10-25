package org.example.business;


import org.example.core.logging.Logger;
import org.example.dataAccess.ProductDao;
import org.example.entities.Product;

import java.util.List;

public class ProductManager {
    private ProductDao productDao;
    private Logger [] loggers;

    public ProductManager(ProductDao productDao, Logger [] loggers) {
        this.productDao = productDao;
        this.loggers = loggers;

    }

    public void add (Product product) throws Exception {
        //Business rules
        if ( product.getUnitPrice() < 10) {
            throw new Exception("Product price have to be greater than 10");
        }


        productDao.add(product);
        for (Logger logger : loggers) {
            logger.log(product.getName());
        }


    }
}
