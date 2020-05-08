package com.example.mortgageplan.repository;

import com.example.mortgageplan.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByName (String name);
    Customer findById(long id);
}
