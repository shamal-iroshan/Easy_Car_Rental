package lk.ijse.easy_car_rental.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RequestCar_PK implements Serializable {
    Request requestID;
    Car carID;
}
