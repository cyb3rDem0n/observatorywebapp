package com.cyberdemon.springboot.repository;


import org.springframework.data.repository.CrudRepository;

import com.cyberdemon.springboot.model.Car;

public interface CarRepositoryInteger extends CrudRepository<Car, Integer>{
}
