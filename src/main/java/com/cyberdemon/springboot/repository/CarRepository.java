package com.cyberdemon.springboot.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.cyberdemon.springboot.model.Car;

public interface CarRepository extends CrudRepository<Car, String> {
	List<Car> findByCompany(String company);
	//Stream<Car> findCarsByCompany(String company);

}
