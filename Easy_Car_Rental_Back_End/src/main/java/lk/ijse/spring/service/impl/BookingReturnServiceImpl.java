package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.BookingReturnDto;
import lk.ijse.spring.entity.BookingReturn;
import lk.ijse.spring.repo.BookingRepo;
import lk.ijse.spring.repo.BookingReturnRepo;
import lk.ijse.spring.service.BookingReturnService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingReturnServiceImpl implements BookingReturnService {

    @Autowired
    BookingReturnRepo returnRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveBookingReturn(BookingReturnDto dto) {
        BookingReturn aReturn = mapper.map(dto, BookingReturn.class);
        aReturn.setReturnID(getLastID());
        returnRepo.save(aReturn);
    }

    @Override
    public void updateBookingReturn(BookingReturnDto dto) {
        if (returnRepo.existsById(dto.getReturnID())){
            returnRepo.save(mapper.map(dto, BookingReturn.class));
        }else{
            throw new RuntimeException("No such Return for update..!");
        }
    }

    @Override
    public void deleteBookingReturn(String id) {
        if (returnRepo.existsById(id)){
            returnRepo.deleteById(id);
        }else{
            throw new RuntimeException("No Return for delete id: " + id);
        }
    }

    @Override
    public BookingReturnDto searchBookingReturn(String id) {
        Optional<BookingReturn> bookingReturn = returnRepo.findById(id);
        if(bookingReturn.isPresent()){
            return mapper.map(bookingReturn, BookingReturnDto.class);
        }else{
            throw new RuntimeException("No Return for id: " + id);
        }
    }

    @Override
    public List<BookingReturnDto> getAllBookingReturn() {
        List<BookingReturn> bookingReturns = returnRepo.findAll();
        return mapper.map(bookingReturns, new TypeToken<List<BookingReturnDto>>(){}.getType());
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
