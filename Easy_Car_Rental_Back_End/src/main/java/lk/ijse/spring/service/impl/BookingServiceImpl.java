package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.BookingDto;
import lk.ijse.spring.entity.Booking;
import lk.ijse.spring.repo.BookingRepo;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveBooking(BookingDto dto) {
        Booking booking = modelMapper.map(dto, Booking.class);
        booking.setBookingID(getLastID());
        bookingRepo.save(booking);
    }

    @Override
    public void updateBooking(BookingDto dto) {

    }

    @Override
    public void deleteBooking(String id) {

    }

    @Override
    public BookingDto searchBooking(String id) {
        return null;
    }

    @Override
    public List<BookingDto> getAllBooking() {
        return null;
    }

    @Override
    public String getLastID() {
        String lastID = bookingRepo.getLastID();
        if (lastID != null) {
            String[] split = lastID.split("B");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "B00" + id;
            else if (id < 100) return "B0" + id;
            else return "B" + id;
        }else{
            return "B001";
        }
    }
}
