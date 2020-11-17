package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentDurationDto {
    private String rdID;
    private double dailyRate;
    private double monthlyRate;
}
