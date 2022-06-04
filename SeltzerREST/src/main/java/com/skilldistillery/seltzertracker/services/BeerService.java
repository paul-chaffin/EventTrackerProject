package com.skilldistillery.seltzertracker.services;

import java.util.List;

import com.skilldistillery.seltzertracker.entities.Beer;

public interface BeerService {

	List<Beer> index();
	Beer showBeerById(int id);
	Beer createBeer(Beer newBeer);
	boolean deleteBeer(Integer id);
	Beer updateBeer(Integer id, Beer beer);

	
}
