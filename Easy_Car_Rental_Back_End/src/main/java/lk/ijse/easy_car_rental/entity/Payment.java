package lk.ijse.easy_car_rental.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Payment {
    @Id
    String paymentID;
    Date date;
    String paymentType;
    double amount;

    @OneToOne
    @JoinColumn(name = "returnid", referencedColumnName = "returnID")
    Return aReturn;
}
