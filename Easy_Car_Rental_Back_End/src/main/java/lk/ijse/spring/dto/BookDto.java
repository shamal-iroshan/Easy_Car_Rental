package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BookDto {
    private String bookingID;
    private String date;
    private String pickupDate;
    private String status;
    private String note;
    private String returnDate;
    private String customer;
    private String car;
    private String driver;
}
