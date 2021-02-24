package com.meridal.examples.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.meridal.examples.domain.Vehicle;
import com.meridal.examples.domain.VehicleModel;

/**
 * Recording DynamoDB Repository.
 * @author Martin Ingram
 */
@EnableScan
public interface VehicleRepository extends CrudRepository<Vehicle, VehicleModel> {
}
