package org.example.business;

import org.example.dataAccess.CarDao;
import org.example.entities.Car;

public class CarManager {
    private CarDao carDao;

    public CarManager(CarDao carDao) {
        this.carDao = carDao;
    }

    public void add (Car car){
        carDao.add(car);
    };
    public void delete (Car car){
        carDao.delete(car);

    };

    public void update (Car car){
        carDao.update(car);
    };
}
