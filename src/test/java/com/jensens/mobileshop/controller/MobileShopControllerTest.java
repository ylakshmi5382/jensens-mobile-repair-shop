package com.jensens.mobileshop.controller;

import com.jensens.mobileshop.model.Customer;
import com.jensens.mobileshop.repository.CustomerRepository;
import com.jensens.mobileshop.service.MobileShopService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MobileShopControllerTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private MobileShopService mobileShopService;

    @InjectMocks
    private MobileShopController mobileShopController;

    @Test
    public void testCreateCustomer() {
        Customer newCustomer = new Customer("John Doe", "1234567890", "john.doe@email.com");

        // Mock mobileShopService behavior (stubbing)
        when(mobileShopService.addCustomer(newCustomer)).thenReturn(newCustomer);

        // Call the controller method
        ResponseEntity<Customer> response = mobileShopController.addCustomer(newCustomer);

        // Verify response status and content
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(newCustomer);

        // Verify method calls on mobileShopService (optional)
        verify(mobileShopService).addCustomer(newCustomer);
    }

    @Test
    public void testGetCustomerById_Found() {

        Customer expectedCustomer = new Customer( "Jane Doe", "9876543210", "jane.doe@email.com");

        // Mock mobileShopService behavior
        when(mobileShopService.findByMobile(expectedCustomer.getPhoneNumber())).thenReturn(List.of(expectedCustomer));

        // Call the controller method
        ResponseEntity<List<Customer>> response = mobileShopController.getCustomer(expectedCustomer.getPhoneNumber());

        // Verify response status and content
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        List<Customer> customers = response.getBody();
        assertThat(customers.get(0)).isEqualTo(expectedCustomer);
    }

}