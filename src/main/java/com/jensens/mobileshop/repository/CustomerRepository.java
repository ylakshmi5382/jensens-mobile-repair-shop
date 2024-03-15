package com.jensens.mobileshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

    List<CustomerEntity> findByMobile(String mobile);

    CustomerEntity save(CustomerEntity customer);
}
