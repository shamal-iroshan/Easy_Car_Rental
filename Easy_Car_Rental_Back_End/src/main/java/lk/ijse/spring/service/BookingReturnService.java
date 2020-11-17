package lk.ijse.spring.service;

import lk.ijse.spring.dto.BookingReturnDto;

import java.util.List;

public interface BookingReturnService {
    void saveBookingReturn(BookingReturnDto dto);
    void updateBookingReturn(BookingReturnDto dto);
    void deleteBookingReturn(String id);
    BookingReturnDto searchBookingReturn(String id);
    List<BookingReturnDto> getAllBookingReturn();
    String getLastID();
}
