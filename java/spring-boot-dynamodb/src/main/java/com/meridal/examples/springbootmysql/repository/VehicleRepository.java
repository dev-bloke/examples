package com.meridal.examples.springbootmysql.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.meridal.examples.springbootmysql.domain.Vehicle;
import com.meridal.examples.springbootmysql.domain.VehicleModel;

/**
 * Recording DynamoDB Repository.
 * @author Martin Ingram
 */
@EnableScan
public interface VehicleRepository extends CrudRepository<Vehicle, VehicleModel> {
}
