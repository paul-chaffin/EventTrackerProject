package com.skilldistillery.seltzertracker.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.seltzertracker.entities.Beer;

public interface BeerService {

	List<Beer> index();
	
	Beer showBeerById(int id);
	
	Beer createBeer(Beer newBeer);
	
	boolean deleteBeer(Integer id);
	
	Beer updateBeer(Integer id, Beer beer);
	
	List<Beer> findByStyleLike(String pattern);
	
	// See note in controller
	public List<Beer> showByStyleSearch(String keyword);
	
	List<Beer> findByBrewerLike(String pattern);
	
	List<Beer> queryByAbvInRange(float low, float high);
	
}
