package lk.ijse.easy_car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class FreeMillage {
    @Id
    private String freeMillageID;
    private double price;
    private String duration;

    @OneToOne(mappedBy = "freeMillage", cascade = CascadeType.ALL)
    private Car car;
}
