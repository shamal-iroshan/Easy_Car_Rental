package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepo extends JpaRepository<Login,String> {

    @Query(value = "SELECT userID FROM login ORDER BY userID DESC LIMIT 1", nativeQuery = true)
    String getLastID();

}
