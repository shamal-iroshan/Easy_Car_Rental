package lk.ijse.easy_car_rental.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    String userID;
    String password;
    String role;
}
