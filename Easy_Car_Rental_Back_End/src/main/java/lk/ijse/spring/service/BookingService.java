package lk.ijse.spring.service;

import lk.ijse.spring.dto.BookingDto;

import java.util.List;

public interface BookingService {
    void saveBooking(BookingDto dto);
    void updateBooking(BookingDto dto);
    void deleteBooking(String id);
    BookingDto searchBooking(String id);
    List<BookingDto> getAllBooking();
    String getLastID();
}
