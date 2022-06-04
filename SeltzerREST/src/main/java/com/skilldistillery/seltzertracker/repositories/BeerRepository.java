package com.skilldistillery.seltzertracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.seltzertracker.entities.Beer;

public interface BeerRepository extends JpaRepository<Beer, Integer> {

	public Beer findById(int id);
	public List<Beer> findAll();
	public void deleteById(Integer id);
	// delete by last entered?
	@SuppressWarnings("unchecked")
	public Beer save(Beer newBeer);
	public List<Beer> findByStyleLike(String pattern);
	
	
}
