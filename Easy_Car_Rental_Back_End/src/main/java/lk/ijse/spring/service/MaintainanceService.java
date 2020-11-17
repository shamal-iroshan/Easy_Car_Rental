package lk.ijse.spring.service;

import lk.ijse.spring.dto.MaintainanceDto;

import java.util.List;

public interface MaintainanceService {
    void saveMaintainance(MaintainanceDto dto);
    void updateMaintainance(MaintainanceDto dto);
    void deleteMaintainance(String id);
    MaintainanceDto searchMaintainance(String id);
    List<MaintainanceDto> getAllMaintainance();
    String getLastID();
}
