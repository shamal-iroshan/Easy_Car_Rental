package lk.ijse.easy_car_rental.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Return {
    @Id
    String returnID;
    Date date;
    double noOfKm;

    @OneToOne(mappedBy = "return", cascade = CascadeType.ALL)
    RequestDetail requestDetail;

    @OneToOne(mappedBy = "return", cascade = CascadeType.ALL)
    Payment payment;
}
