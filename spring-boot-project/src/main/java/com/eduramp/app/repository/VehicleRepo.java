package com.eduramp.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduramp.app.model.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle,Integer>{

	public List<Vehicle> findByName(String name);

}
