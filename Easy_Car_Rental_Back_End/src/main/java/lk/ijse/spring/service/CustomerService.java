package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDto dto);
    void updateCustomer(CustomerDto dto);
    CustomerDto searchCustomer(String id);
    void deleteCustomer(String id);
    List<CustomerDto> getAllCustomer();
    String getLastLoginID();
    CustomerDto login(String userName, String password);
    void verifyCustomer(String id);
}
