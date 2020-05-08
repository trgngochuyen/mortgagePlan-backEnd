package com.example.mortgageplan.service;

import com.example.mortgageplan.entity.Customer;
import com.example.mortgageplan.utils.MathHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CrudRepository<Customer, Long> repository;

    public Iterable<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer saveCustomer(Customer customer) { return repository.save(customer);}

    public float calculateMonthlyPayment(int years, float interestRate, float loan) {
        // number of payments
        int p = years*12;
        // (interestRate + 1)^P
        float expRes = MathHelper.power((1 + (interestRate / 100)), p);
        // monthlyPayment
        return loan*((interestRate/100)*expRes)/(expRes-1);
    }
}