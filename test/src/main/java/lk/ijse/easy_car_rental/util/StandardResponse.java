package lk.ijse.easy_car_rental.util;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
