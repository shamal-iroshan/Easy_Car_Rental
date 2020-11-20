package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DriverRepo extends JpaRepository<Driver,String> {

    @Query(value = "SELECT driverID FROM driver ORDER BY driverID DESC LIMIT 1", nativeQuery = true)
    String getLastID();

    @Query(value = "SELECT * FROM driver WHERE userName=:userName AND password=:password",nativeQuery = true)
    Driver login(@Param("userName") String userName, @Param("password") String password);

}
