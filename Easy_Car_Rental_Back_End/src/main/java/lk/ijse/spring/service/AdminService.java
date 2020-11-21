package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDto;

import java.util.List;

public interface AdminService {
    void saveAdmin(AdminDto dto);
    void updateAdmin(AdminDto dto);
    AdminDto searchAdmin(String id);
    void deleteAdmin(String id);
    List<AdminDto> getAllAdmin();
    String getLastLoginID();
    AdminDto login(String userName, String password);
}
