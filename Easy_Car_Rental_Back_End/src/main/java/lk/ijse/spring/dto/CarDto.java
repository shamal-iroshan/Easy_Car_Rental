package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto {
    private String carID;
    private String Brand;
    private String Type;
    private int numberOfPassengers;
    private String transmissionType;
    private String fuelType;
    private double priceForExtraKM;
    private String registrationNumber;
    private String colour;
}
