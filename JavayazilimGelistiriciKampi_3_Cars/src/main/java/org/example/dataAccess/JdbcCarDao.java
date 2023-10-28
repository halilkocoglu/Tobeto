package org.example.dataAccess;

import org.example.entities.Car;

public class JdbcCarDao implements CarDao{
    @Override
    public void add(Car car) {
        System.out.println(car.getBrand()+ "-" + car.getModel() + " added to DB with JDBC");
    }

    @Override
    public void delete(Car car) {
        System.out.println(car.getBrand()+ "-" + car.getModel() + " deleted from DB with JDBC");
    }

    @Override
    public void update(Car car) {
        System.out.println(car.getBrand()+ "-" + car.getModel() + " updated to DB with JDBC");
    }
}
