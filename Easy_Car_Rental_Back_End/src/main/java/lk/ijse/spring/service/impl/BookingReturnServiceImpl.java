package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.BookingReturnDto;
import lk.ijse.spring.repo.BookingReturnRepo;
import lk.ijse.spring.service.BookingReturnService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingReturnServiceImpl implements BookingReturnService {

    @Autowired
    BookingReturnRepo returnRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveBookingReturn(BookingReturnDto dto) {

    }

    @Override
    public void updateBookingReturn(BookingReturnDto dto) {

    }

    @Override
    public void deleteBookingReturn(String id) {

    }

    @Override
    public BookingReturnDto searchBookingReturn(String id) {
        return null;
    }

    @Override
    public List<BookingReturnDto> getAllBookingReturn() {
        return null;
    }

    @Override
    public String getLastID() {
        String lastID = returnRepo.getLastID();
        if (lastID != null) {
            String[] split = lastID.split("R");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "R00" + id;
            else if (id < 100) return "R0" + id;
            else return "R" + id;
        }else{
            return "R001";
        }
    }
}
