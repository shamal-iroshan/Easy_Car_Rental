package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Maintainance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MaintainanceRepo extends JpaRepository<Maintainance,String> {

    @Query(value = "SELECT maintainanceID FROM maintainance ORDER BY maintainanceID DESC LIMIT 1", nativeQuery = true)
    String getLastID();

}
