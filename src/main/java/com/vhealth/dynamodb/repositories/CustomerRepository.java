package com.vhealth.dynamodb.repositories;

import com.vhealth.dynamodb.model.Customer;
import com.vhealth.dynamodb.model.Vehicle;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface CustomerRepository extends CrudRepository<Customer, String> {
    List<Customer> findById(String id);
}
