package lk.ijse.spring.service;

import lk.ijse.spring.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    void savePayment(PaymentDto dto);
    void updatePayment(PaymentDto dto);
    void deletePayment(String id);
    PaymentDto searchPayment(String id);
    List<PaymentDto> getAllPayments();
    String getLastID();
}
