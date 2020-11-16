package lk.ijse.easy_car_rental.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @Id
    String carID;
    String Brand;
    String Type;
    int numberOfPassengers;
    String transmissionType;
    String fuelType;
    double priceForExtraKM;
    String registrationNumber;
    String colour;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    List<Request> requests = new ArrayList<>();
}
