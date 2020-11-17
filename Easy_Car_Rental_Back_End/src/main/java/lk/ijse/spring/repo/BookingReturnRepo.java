package lk.ijse.spring.repo;

import lk.ijse.spring.entity.BookingReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingReturnRepo extends JpaRepository<BookingReturn,String> {

    @Query(value = "SELECT returnID FROM bookingreturn ORDER BY returnID DESC LIMIT 1", nativeQuery = true)
    String getLastID();

}
