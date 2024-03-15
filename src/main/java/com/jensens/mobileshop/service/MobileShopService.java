package com.jensens.mobileshop.service;

import com.jensens.mobileshop.model.Customer;
import com.jensens.mobileshop.repository.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MobileShopService {
    @Autowired
    private com.jensens.mobileshop.repository.CustomerRepository customerRepository;

    // Read
    public List<Customer> findByMobile(String country) {
        List<CustomerEntity> customerEntitiesResponse = customerRepository.findByMobile(country);
        return customerEntitiesResponse.stream().map(entity -> mapToCustomer(entity)).collect(Collectors.toList());
    }

    public Customer addCustomer(Customer customer) {

        CustomerEntity customerEntity = mapToCustomerEntity(customer);
        CustomerEntity customerEntity1 = customerRepository.save(customerEntity);
        return mapToCustomer(customerEntity1);
    }

    public static CustomerEntity mapToCustomerEntity(Customer source) {
        Function<Customer, CustomerEntity> mapper = c -> CustomerEntity.builder().
                email(c.getEmail()).
                mobile(c.getPhoneNumber()).
                name(c.getName()).build();
        return mapper.apply(source);
    }

    public static Customer mapToCustomer(CustomerEntity source) {
        Function<CustomerEntity, Customer> mapperToCustomer = c -> Customer.builder().
                email(c.getEmail()).
                phoneNumber(c.getMobile()).
                name(c.getName()).build();
        return mapperToCustomer.apply(source);
    }

}
