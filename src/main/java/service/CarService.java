package service;

import dao.CarDAO;
import entity.Car;
import entity.CarBodyType;

import java.util.List;

public class CarService {
    private CarDAO carDAO = new CarDAO();

    public void addCar(Car car) {
        carDAO.create(car);
    }

    public void findById(Long id) {
        carDAO.searchById(id);
    }

    public void editCar(Car car) {
        carDAO.update(car);
    }

    public void removeCar(Car car) {
        carDAO.remove(car);
    }

    public void searchByProductionDate(int year) {
        List<Car> cars = carDAO.findAllByProductionDate(year);
        cars.forEach(System.out::println);

    }

    public void findCarsBodyType(CarBodyType carBodyType) {
        List<Car> carsBodyType = carDAO.findAllCarBodyType(carBodyType);
        carsBodyType.forEach(System.out::println);

    }

    public void findCarsOrderedByProductionDate() {
        List<Car> carsOrderedByDate = carDAO.findAllOrderByProductionDate();
        carsOrderedByDate.forEach(System.out::println);

    }

    public void findTheOldestCar() {
        List<Car> carTheOldest = carDAO.findTheOldestCar();
        carTheOldest.forEach(System.out::println);
    }


}
