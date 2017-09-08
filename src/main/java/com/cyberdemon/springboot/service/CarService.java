package com.cyberdemon.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyberdemon.springboot.model.Car;
import com.cyberdemon.springboot.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	CarRepository carRepository;

	public List<Car> getAllCars() {
		List<Car> carlist = new ArrayList<>();
		carRepository.findAll().forEach(carlist::add);
		return carlist;
	}

	public void addCar(Car car) {
		carRepository.save(car);
	}
	// do solo la stringa in ingresso
	public List<Car> findByCompany(String company){
		return carRepository.findByCompany(company);
	}
	

	/*//troppo pomposa
	public Stream<Car> searchByCompany(String value) {
		Stream<Car> result = carRepository.findCarsByCompany(value);
			result
			.filter(x -> value.equals(x.getCompany()))
			.findAny()
			.orElse(null);

		result.forEach(car -> result.collect(Collectors.toList()));
		return result;
	}*/
	

/*	// bo
	public List<Car> findByCompany(String company){
		List<Car> result = new ArrayList<>();
		carRepository.findByCompany(company).forEach(result::add);
			return result;
	}
*/
	/*
	 * public List<Car> findAllCarsByCompany(String company){ List<Car> carlist_ =
	 * new ArrayList<>(); carRepository.findAll().forEach(carlist -> {
	 * if(carRepository.findOne(company) != null) { carlist_.add(carlist); } });
	 * return carlist_; }
	 */

	/*
	 * public List<Car> findAllCarsByCompany(String searched_company){ List<Car>
	 * list = null; carRepository.findAll().forEach(company -> {
	 * if(searched_company.equals(company)) list.add(company); }); return list;
	 * 
	 * }
	 */

	/*
	 * public void delete(int id) { carRepo.delete(id); }
	 */

	/*
	 * public Car find(String model) { return (Car) carRepository.findOne(model); }
	 */

	/*
	 * public Car find(int id) { return carRepo.findOne(id); }
	 */
}
