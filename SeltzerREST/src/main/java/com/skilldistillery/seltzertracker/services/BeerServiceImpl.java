package com.skilldistillery.seltzertracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.seltzertracker.entities.Beer;
import com.skilldistillery.seltzertracker.repositories.BeerRepository;

@Service
public class BeerServiceImpl implements BeerService{

	@Autowired
	BeerRepository repo;
	
	@Override
	public List<Beer> index() {
		return	repo.findAll();
	}

	@Override
	public Beer showBeerById(int id) {
		
		return repo.findById(id);
	}

	@Override
	public Beer createBeer(Beer newBeer) {
		return repo.save(newBeer);
	}

	@Override
	public boolean deleteBeer(Integer id) {
		 repo.deleteById(id);
		 boolean success = !repo.existsById(id);
		return success;
	}

	@Override
	public Beer updateBeer(Integer id, Beer beer) {
		Beer inDb = repo.findById(id).get();
		inDb.setAbv(beer.getAbv());
		inDb.setBrewer(beer.getBrewer());
		inDb.setName(beer.getName());
		inDb.setDateTime(beer.getDateTime());
		inDb.setOrigin(beer.getOrigin());
		inDb.setPurveyor(beer.getPurveyor());
		inDb.setStyle(beer.getStyle());
		inDb.setStyleTwo(beer.getStyleTwo());
		repo.save(inDb);
		return inDb;
	}

	
	
}
