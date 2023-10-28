package org.example;

import org.example.business.CarManager;
import org.example.dataAccess.HibernateCarDao;
import org.example.entities.Car;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car(1,"BMW","X5",1200000,15);
        CarManager carManager =new CarManager(new HibernateCarDao());
        carManager.add(car1);
    }
}