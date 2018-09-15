import entity.Car;
import entity.CarBodyType;
import service.CarService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService();
        Car car1 = new Car();
        car1.setBrand("Toyota");
        car1.setModel("Yaris");
        car1.setCarBodyType(CarBodyType.SEDAN);
        car1.setProductionDate(LocalDate.of(2000, 9, 9));
        car1.getAge();
        car1.setColor("black");
        car1.setIloscPrzejechanychKm(10000L);
        car1.getModifiedDate();


        Car car2 = new Car();
        car2.setBrand("Nissan");
        car2.setModel("Micra");
        car2.setCarBodyType(CarBodyType.CABRIO);
        car2.setProductionDate(LocalDate.of(2000, 1, 1));
        car2.getAge();
        car2.setColor("green");
        car2.setIloscPrzejechanychKm(5000L);
        car2.getModifiedDate();

        Car car3 = new Car();
        car3.setBrand("Seat");
        car3.setModel("Ibiza");
        car3.setCarBodyType(CarBodyType.COMBI);
        car3.setProductionDate(LocalDate.of(2010, 5, 7));
        car3.getAge();
        car3.setColor("yellow");
        car3.setIloscPrzejechanychKm(35000L);
        car3.getModifiedDate();

        Car car4 = new Car();
        car4.setBrand("Volvo");
        car4.setModel("X");
        car4.setCarBodyType(CarBodyType.SEDAN);
        car4.setProductionDate(LocalDate.of(2000, 6, 9));
        car4.getAge();
        car4.setColor("purple");
        car4.setIloscPrzejechanychKm(55000L);
        car4.getModifiedDate();

        carService.addCar(car1);
        carService.addCar(car2);
        carService.addCar(car3);
        carService.addCar(car4);


        //  carService.findById(1L);

        //  car1.setColor("blue");
        //     carService.editCar(car1);


        //  carService.removeCar(car1);

      //  carService.searchByProductionDate(2000);///nie podoba mi się format daty
   carService.findCarsBodyType(CarBodyType.SEDAN);
     //   carService.findCarsOrderedByProductionDate();

        //carService.findTheOldestCar();
    }
}
