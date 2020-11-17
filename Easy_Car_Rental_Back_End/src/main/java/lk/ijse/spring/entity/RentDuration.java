package lk.ijse.spring.entity;

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
public class RentDuration {
    @Id
    private String rdID;
    private double dailyRate;
    private double monthlyRate;

    @OneToOne(mappedBy = "rentDuration", cascade = CascadeType.ALL)
    private lk.ijse.spring.entity.Car car;
}
