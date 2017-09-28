package com.vhealth.dynamodb.repositories;

import com.vhealth.dynamodb.model.Vehicle;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface VehicleRepository extends CrudRepository<Vehicle, String> {
    List<Vehicle> findById(String id);
}
