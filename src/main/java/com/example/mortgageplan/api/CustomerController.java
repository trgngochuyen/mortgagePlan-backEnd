package com.example.mortgageplan.api;

import com.example.mortgageplan.entity.Customer;
import com.example.mortgageplan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping()
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/api/v1/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {

        float monthlyPayment = customerService.calculateMonthlyPayment(customer.getYears(), customer.getInterestRate(), customer.getLoan());
        customer.setMonthlyPayment(monthlyPayment);
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/api/v1/customers")
    public Iterable<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }


}
