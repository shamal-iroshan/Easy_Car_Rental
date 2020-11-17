package lk.ijse.spring.service;

import lk.ijse.spring.dto.FreeMillageDto;

import java.util.List;

public interface FreeMillageService {
    void saveFreeMillage(FreeMillageDto dto);
    void updateFreeMillage(FreeMillageDto dto);
    void deleteFreeMillage(String id);
    FreeMillageDto searchFreeMillage(String id);
    List<FreeMillageDto> getAllFreeMillages();
    String getLastID();
}
