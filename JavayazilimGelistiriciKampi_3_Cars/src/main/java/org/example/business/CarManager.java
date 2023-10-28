package org.example.business;

import org.example.dataAccess.CarDao;
import org.example.entities.Car;

public class CarManager {
    private CarDao carDao;

    public CarManager(CarDao carDao) {
        this.carDao = carDao;
    }

    public void add (Car car) throws Exception {
        if (car.getModel().length() <= 1 ) {
            throw new Exception("Car must have a model name");
        }
        if (car.getBrand().length() <= 1 ) {
            throw new Exception("Car must have a brand name");
        }
        if (car.getInStock()< 1) {
            throw new Exception("Car amount must be higher than 0 in stock");
        }
        if(car.getPrice() < 12000) {
            throw new Exception("Price have to be higher than 12000");
        }else
            carDao.add(car);
    };
    public void delete (Car car){
        carDao.delete(car);
    };

    public void update (Car car){
        carDao.update(car);
    };
}
