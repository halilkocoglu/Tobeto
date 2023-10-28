package org.example;

import org.example.business.CarManager;
import org.example.dataAccess.HibernateCarDao;
import org.example.dataAccess.JdbcCarDao;
import org.example.entities.Car;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car(1,"BMW","X5",1200000,15);
        CarManager carManager =new CarManager(new JdbcCarDao());
        carManager.add(car1);
        carManager.delete(car1);
        carManager.update(car1);
    }
}