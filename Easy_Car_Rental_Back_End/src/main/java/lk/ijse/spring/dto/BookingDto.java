package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDto {
    private String bookingID;
    private Date date;
    private Date returnDate;
    private int lastKM;
    private double lossDamageWaiver;
    private String status;
    private String note;
}
