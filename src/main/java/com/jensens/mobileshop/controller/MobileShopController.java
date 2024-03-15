package com.jensens.mobileshop.controller;

import com.jensens.mobileshop.model.Customer;
import com.jensens.mobileshop.repository.CustomerEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/mobileshop")
public class MobileShopController {


    public final com.jensens.mobileshop.service.MobileShopService mobileShopService;

    public MobileShopController(com.jensens.mobileshop.service.MobileShopService mobileShopService){
        this.mobileShopService = mobileShopService;
    }

    @GetMapping("/{mobile}")
    public ResponseEntity<List<Customer>> getCustomer(@PathVariable String mobile) {
        List<Customer> customers = mobileShopService.findByMobile(mobile);
        if (!customers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(customers);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer customerResponse = mobileShopService.addCustomer(customer);
               return ResponseEntity.status(HttpStatus.CREATED).body(customerResponse);
    }


}
