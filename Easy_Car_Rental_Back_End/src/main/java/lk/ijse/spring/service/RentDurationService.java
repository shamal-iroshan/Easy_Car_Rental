package lk.ijse.spring.service;

import lk.ijse.spring.dto.RentDurationDto;

import java.util.List;

public interface RentDurationService {
    void saveRentDuration(RentDurationDto dto);
    void updateRentDuration(RentDurationDto dto);
    void deleteRentDuration(String id);
    RentDurationDto searchRentDuration(String id);
    List<RentDurationDto> getAllRentDurations();
    String getLastID();
}
