package com.meridal.examples.repository;

import org.springframework.data.repository.CrudRepository;

import com.meridal.examples.domain.Vehicle;
import com.meridal.examples.domain.VehicleModel;

/**
 * Vehicle CRUD Repository.
 * @author Martin Ingram
 */
public interface VehicleRepository extends CrudRepository<Vehicle, VehicleModel> {
}
