package com.skilldistillery.seltzertracker.services;

import java.util.List;

import com.skilldistillery.seltzertracker.entities.Coffee;

public interface CoffeeService {

	List<Coffee> index();
	Coffee showCoffeeById(int id);
	Coffee createCoffee(Coffee newCoffee);
	boolean deleteCoffee(Integer id);
	Coffee updateCoffee(Integer id, Coffee coffee);
	
}
