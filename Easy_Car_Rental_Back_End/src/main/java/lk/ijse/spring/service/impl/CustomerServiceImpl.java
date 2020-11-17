package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDto dto) {
        if (!repo.existsById(dto.getId())) {
            Customer c = mapper.map(dto, Customer.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Customer already exist..!");
        }

    }

    @Override
    public void updateCustomer(CustomerDto dto) {
        if (repo.existsById(dto.getId())) {
            Customer c = mapper.map(dto, Customer.class);
            repo.save(c);
        } else {
            throw new RuntimeException("No such customer for update..!");
        }
    }

    @Override
    public CustomerDto searchCustomer(String id) {
        Optional<Customer> customer = repo.findById(id);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), CustomerDto.class);
        } else {
            throw new RuntimeException("No Customer for id: " + id);
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No customer for delete id: " + id);
        }

    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<CustomerDto>>() {
        }.getType());
    }


}
