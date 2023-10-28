package org.example.dataAccess;

import org.example.entities.Car;

public class HibernateCarDao implements CarDao{
    @Override
    public void add(Car car) {
        System.out.println(car.getBrand()+ "-" + car.getModel() + " added to DB with Hibernate");
    }

    @Override
    public void delete(Car car) {
        System.out.println(car.getBrand()+ "-" + car.getModel() + " deleted from DB with Hibernate");
    }

    @Override
    public void update(Car car) {
        System.out.println(car.getBrand()+ "-" + car.getModel() + " updated to DB with Hibernate");
    }
}

