package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Login {
    @Id
    private String userID;
    private String userName;
    private String password;
    private String role;

    @OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
    private lk.ijse.spring.entity.Customer customer;

    @OneToOne(mappedBy = "login",cascade = CascadeType.ALL)
    private lk.ijse.spring.entity.Driver driver;
}
