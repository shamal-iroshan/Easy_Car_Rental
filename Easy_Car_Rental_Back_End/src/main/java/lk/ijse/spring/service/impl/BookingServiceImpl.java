package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.BookingDto;
import lk.ijse.spring.entity.Booking;
import lk.ijse.spring.repo.BookingRepo;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        System.out.println(booking.toString());
        bookingRepo.save(booking);
    }

    @Override
    public void updateBooking(BookingDto dto) {
        if(bookingRepo.existsById(dto.getBookingID())){
            bookingRepo.save(modelMapper.map(dto, Booking.class));
        }else{
            throw new RuntimeException("No such Booking for update..!");
        }
    }

    @Override
    public void deleteBooking(String id) {
        if(bookingRepo.existsById(id)){
            bookingRepo.deleteById(id);
        }else{
            throw new RuntimeException("No such Booking for update..!");
        }
    }

    @Override
    public BookingDto searchBooking(String id) {
        Optional<Booking> booking = bookingRepo.findById(id);
        if(booking.isPresent()){
            return modelMapper.map(booking, BookingDto.class);
        }else{
            throw new RuntimeException("No Booking for id: " + id);
        }
    }

    @Override
    public List<BookingDto> getAllBooking() {
        List<Booking> bookings = bookingRepo.findAll();
        return modelMapper.map(bookings, new TypeToken<List<BookingDto>>(){}.getType());
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
