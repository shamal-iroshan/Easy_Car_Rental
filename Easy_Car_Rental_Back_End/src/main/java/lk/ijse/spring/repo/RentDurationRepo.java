package lk.ijse.spring.repo;

import lk.ijse.spring.entity.RentDuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentDurationRepo extends JpaRepository<RentDuration,String> {

    @Query(value = "SELECT rdID FROM rentduration ORDER BY rdID DESC LIMIT 1", nativeQuery = true)
    String getLastID();

}
