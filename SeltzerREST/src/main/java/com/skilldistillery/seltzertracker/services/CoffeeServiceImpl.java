package com.skilldistillery.seltzertracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.seltzertracker.entities.Coffee;
import com.skilldistillery.seltzertracker.entities.Seltzer;
import com.skilldistillery.seltzertracker.repositories.CoffeeRepository;

@Service
public class CoffeeServiceImpl implements CoffeeService{

	@Autowired
	CoffeeRepository repo;
	
	@Override
	public List<Coffee> index() {
		return	repo.findAll();
	}

	@Override
	public Coffee showCoffeeById(int id) {
		
		return repo.findById(id);
	}

	@Override
	public Coffee createCoffee(Coffee newCoffee) {
		return repo.save(newCoffee);
	}

	@Override
	public boolean deleteCoffee(Integer id) {
		 repo.deleteById(id);
		 boolean success = !repo.existsById(id);
		return success;
	}

	@Override
	public Coffee updateCoffee(Integer id, Coffee coffee) {
		Coffee inDb = repo.findById(id).get();
		inDb.setDateTime(coffee.getDateTime());
		inDb.setOunces(coffee.getOunces());
		repo.save(inDb);
		return inDb;
	}

	@Override
	public List<Coffee> queryByCreamerAndSugar() {
		return repo.queryByCreamerAndSugar();
	}

	@Override
	public List<Coffee> queryByNoCreamerAndNoSugar() {
		return repo.queryByNoCreamerAndNoSugar();
		 
	}

	
	
}
