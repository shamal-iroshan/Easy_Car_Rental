package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    @Query(value = "SELECT customerID FROM customer ORDER BY customerID DESC LIMIT 1", nativeQuery = true)
    String getLastID();

    @Query(value = "SELECT * FROM customer WHERE userName=:userName AND password=:password",nativeQuery = true)
    Customer login(@Param("userName") String userName,@Param("password") String password);

    @Query(value = "UPDATE customer SET verified='1' WHERE customerID=:id",nativeQuery = true)
    void verify(@Param("id") String id);
}
