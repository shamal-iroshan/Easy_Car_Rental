package lk.ijse.easy_car_rental.repo;

import lk.ijse.easy_car_rental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {
}
