package com.skilldistillery.seltzertracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skilldistillery.seltzertracker.entities.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

	public Coffee findById(int id);
	public List<Coffee> findAll();
	public void deleteById(Integer id);
	// delete by last entered?
	@SuppressWarnings("unchecked")
	public Coffee save(Coffee newCoffee);
	
	@Query(value="SELECT * FROM coffee WHERE creamer = true AND sugar_tbsp IS NOT NULL", nativeQuery=true)
	public List<Coffee> queryByCreamerAndSugar();

	@Query(value="SELECT * FROM coffee WHERE creamer = false AND sugar_tbsp = 0.0", nativeQuery=true)
	public List<Coffee> queryByNoCreamerAndNoSugar();
}
