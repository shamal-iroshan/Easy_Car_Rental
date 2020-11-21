package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.PaymentDto;
import lk.ijse.spring.entity.Payment;
import lk.ijse.spring.repo.PaymentRepo;
import lk.ijse.spring.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void savePayment(PaymentDto dto) {
        Payment payment = modelMapper.map(dto, Payment.class);
        payment.setPaymentID(getLastID());
        paymentRepo.save(payment);
    }

    @Override
    public void updatePayment(PaymentDto dto) {
        if (paymentRepo.existsById(dto.getPaymentID())){
            paymentRepo.save(modelMapper.map(dto,Payment.class));
        }else {
            throw new RuntimeException("No such payment for update..!");
        }
    }

    @Override
    public void deletePayment(String id) {
        if (paymentRepo.existsById(id)){
            paymentRepo.deleteById(id);
        }else{
            throw new RuntimeException("No payment for delete id: " + id);
        }
    }

    @Override
    public PaymentDto searchPayment(String id) {
        Optional<Payment> payment = paymentRepo.findById(id);
        if(payment.isPresent()){
            return modelMapper.map(payment, PaymentDto.class);
        }else{
            throw new RuntimeException("No payment for id: " + id);
        }
    }

    @Override
    public List<PaymentDto> getAllPayments() {
        List<Payment> payments = paymentRepo.findAll();
        return modelMapper.map(payments,new TypeToken<List<PaymentDto>>(){}.getType());
    }

    @Override
    public String getLastID() {
        String lastID = paymentRepo.getLastID();
        if (lastID != null) {
            String[] split = lastID.split("P");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "P00" + id;
            else if (id < 100) return "P0" + id;
            else return "P" + id;
        }else{
            return "P001";
        }
    }
}
