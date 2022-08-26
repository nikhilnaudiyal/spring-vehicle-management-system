package com.eduramp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduramp.app.model.Vehicle;
import com.eduramp.app.repository.VehicleRepo;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	VehicleRepo vehicleRepository;
	
	@GetMapping(path="/")
	public String home()
	{
		return "HOMEPAGE";
	}
	
	@PostMapping("/insert")
	public void saveVehicle(@RequestBody Vehicle vehicle)
	{
		vehicleRepository.save(vehicle);
		System.out.println("Vehicle saved successfully!");
	}
	
	@PutMapping("/update")
	public Vehicle update(@RequestBody Vehicle vehicle)
	{
		Vehicle updatedVehicle = vehicleRepository.save(vehicle);
		return updatedVehicle;
	}
	
	@GetMapping("/search/id/{id}")
	public Vehicle searchById(@PathVariable int id)
	{
		return vehicleRepository.findById(id).get();
	}
	
	@GetMapping("/search/name/{name}")
	public List<Vehicle> searchByname(@PathVariable String name)
	{
		return vehicleRepository.findByName(name);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id)
	{
		vehicleRepository.deleteById(id);
	}
	
	@GetMapping("/findallvehicles")
	public List<Vehicle> findAll()
	{
		List<Vehicle> list = vehicleRepository.findAll();
		return list;
	}
}
