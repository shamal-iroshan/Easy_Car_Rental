package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    private lk.ijse.spring.entity.Booking booking;

    @OneToOne(mappedBy = "bookingReturn", cascade = CascadeType.ALL)
    private lk.ijse.spring.entity.Payment payment;

}
