package lk.ijse.easy_car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Car {
    @Id
    private String carID;
    private String Brand;
    private String Type;
    private int numberOfPassengers;
    private String transmissionType;
    private String fuelType;
    private double priceForExtraKM;
    private String registrationNumber;
    private String colour;

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    private List<Maintainance> maintainances = new ArrayList<>();

    @OneToOne(cascade ={CascadeType.ALL})
    @JoinColumn(name = "freeMillageid", referencedColumnName = "freeMillageID", nullable = false)
    private FreeMillage freeMillage;

    @OneToOne(cascade ={CascadeType.ALL})
    @JoinColumn(name = "durationid", referencedColumnName = "rdID", nullable = false)
    private RentDuration rentDuration;

}
