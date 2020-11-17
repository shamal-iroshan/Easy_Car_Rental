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
public class Maintainance {
    @Id
    private String maintainanceID;
    private Date date;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carid", referencedColumnName = "carID", nullable = false)
    private lk.ijse.spring.entity.Car car;
}
