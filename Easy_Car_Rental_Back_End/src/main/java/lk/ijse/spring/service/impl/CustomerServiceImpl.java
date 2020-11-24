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
        Customer customer = mapper.map(dto, Customer.class);
        customer.setCustomerID(getLastLoginID());
        repo.save(customer);
    }


    @Override
    public void updateCustomer(CustomerDto dto) {
        if (repo.existsById(dto.getCustomerID())) {
            repo.save(mapper.map(dto, Customer.class));
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

    @Override
    public String getLastLoginID() {
        String lastID = repo.getLastID();
        if (lastID != null) {
            String[] split = lastID.split("C");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "C00" + id;
            else if (id < 100) return "C0" + id;
            else return "C" + id;
        }else{
            return "C001";
        }
    }

    @Override
    public CustomerDto login(String userName, String password) {
        Customer customer = repo.login(userName, password);
        if (customer == null){
            return null;
        }
        return mapper.map(customer,CustomerDto.class);
    }

    @Override
    public void verifyCustomer(String id) {
        Optional<Customer> customer = repo.findById(id);
        if (customer.isPresent()) {
            Customer customer1 = customer.get();
            customer1.setVerified(1);
            customer1.setCustomerID(id);
            repo.save(customer1);
        } else {
            throw new RuntimeException("No Customer for id: " + id);
        }
    }


}
