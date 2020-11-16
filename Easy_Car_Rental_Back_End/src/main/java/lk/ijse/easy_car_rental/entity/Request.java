package lk.ijse.easy_car_rental.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Request {
    @Id
    String requestID;
    Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cusID", referencedColumnName = "customerID" ,nullable = false)
    Customer customer;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
    List<RequestDetail> requestDetails = new ArrayList<>();
}
