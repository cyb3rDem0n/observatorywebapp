package com.cyberdemon.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyberdemon.springboot.model.Car;
import com.cyberdemon.springboot.repository.CarRepositoryInteger;

@Service
public class CarServiceInteger implements CarRepositoryInteger {
	@Autowired
	CarRepositoryInteger carRepositoryInteger;
	
	public Car find(int id) {
		return carRepositoryInteger.findOne(id);
	}
	
	///// implemented methods ////
	
	@Override
	public <S extends Car> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Car> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Car findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Car> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Car> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer id) {
		carRepositoryInteger.delete(id);
	}

	@Override
	public void delete(Car car) {
		carRepositoryInteger.delete(car);
		
	}

	@Override
	public void delete(Iterable<? extends Car> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
