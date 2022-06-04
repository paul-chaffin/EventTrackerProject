package com.skilldistillery.seltzertracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.seltzertracker.entities.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

	public Coffee findById(int id);
	public List<Coffee> findAll();
	public void deleteById(Integer id);
	// delete by last entered?
	@SuppressWarnings("unchecked")
	public Coffee save(Coffee newCoffee);
	
}
