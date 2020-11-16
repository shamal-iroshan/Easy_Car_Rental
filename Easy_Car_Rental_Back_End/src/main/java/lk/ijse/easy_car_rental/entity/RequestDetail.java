package lk.ijse.easy_car_rental.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RequestDetail {
    @EmbeddedId
    RequestCar_PK requestCar_pk;
    Date date;
    double waiverAmount;
    String deniedReason;

    @ManyToOne
    @JoinColumn(name = "rID", referencedColumnName = "requestID", insertable = false, updatable = false)
    Request request;

    @ManyToOne
    @JoinColumn(name = "cID", referencedColumnName = "carID", insertable = false, updatable = false)
    Car car;

    @OneToOne
    @JoinColumn(name = "dID", referencedColumnName = "driverID", insertable = false, updatable = false)
    Driver driver;

    @OneToOne
    @JoinColumn(name = "returnid", referencedColumnName = "returnID", insertable = false, updatable = false)
    Return areturn;
}
