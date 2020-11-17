package lk.ijse.spring.repo;

import lk.ijse.spring.entity.FreeMillage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FreeMillageRepo extends JpaRepository<FreeMillage,String> {

    @Query(value = "SELECT freeMillageID FROM freemillage ORDER BY freeMillageID DESC LIMIT 1", nativeQuery = true)
    String getLastID();

}
