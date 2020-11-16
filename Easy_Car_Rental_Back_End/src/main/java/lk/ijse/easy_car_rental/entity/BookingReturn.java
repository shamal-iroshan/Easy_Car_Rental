package lk.ijse.easy_car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BookingReturn {
    @Id
    private String returnID;
    private Date date;
    private double noOfKm;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookingid", referencedColumnName = "bookingID",nullable = false)
    private Booking booking;

    @OneToOne(mappedBy = "bookingReturn", cascade = CascadeType.ALL)
    private Payment payment;

}
