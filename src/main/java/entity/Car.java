package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

@NamedQueries({
        @NamedQuery(name = "Car.searchById", query = "select c from Car c where c.id= :id")
}

)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;


    @Column
    @Enumerated(EnumType.STRING)
    private CarBodyType carBodyType;

    @Column
    private LocalDate productionDate;
    @Column
    private int age;
    @Column
    private String color;
    @Column
    private Long iloscPrzejechanychKm;
    @Column
    private Timestamp modifiedDate;

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public CarBodyType getCarBodyType() {
        return carBodyType;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public String getColor() {
        return color;
    }

    public Long getIloscPrzejechanychKm() {
        return iloscPrzejechanychKm;
    }

    public Timestamp getModifiedDate() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return modifiedDate=timestamp;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCarBodyType(CarBodyType carBodyType) {
        this.carBodyType = carBodyType;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setIloscPrzejechanychKm(Long iloscPrzejechanychKm) {
        this.iloscPrzejechanychKm = iloscPrzejechanychKm;
    }


    public int getAge() {
                int productionDate1 = productionDate.getYear();
        int localDate = LocalDateTime.now().getYear();
        return age = localDate-productionDate1;
    }



    public void setAge(int age) {
        this.age = age;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", carBodyType=" + carBodyType +
                ", productionDate=" + productionDate +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", iloscPrzejechanychKm=" + iloscPrzejechanychKm +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
