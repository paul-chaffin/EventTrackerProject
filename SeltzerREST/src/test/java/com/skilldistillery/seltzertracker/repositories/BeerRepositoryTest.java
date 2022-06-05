package com.skilldistillery.seltzertracker.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.seltzertracker.entities.Beer;

@SpringBootTest
class BeerRepositoryTest {

	@Autowired
	private BeerRepository repo;
	
	@Test
	void test_findAll() {
		List<Beer> beers = repo.findAll();
		assertNotNull(beers);
		assertTrue(beers.size() > 0);
		assertEquals(7, beers.size());
	}
	
	@Test
	void test_findById() {
		Beer beer = repo.findById(7);
		assertNotNull(beer);
		assertEquals("Great Lakes Brewing Co.", beer.getBrewer());
	}
	
	@Test
	void test_findByStyleLike() {
		List<Beer> beers = repo.findByStyleLike("Winter Warmer");
		assertNotNull(beers);
		assertEquals("Great Lakes Brewing Co.", beers.get(0).getBrewer());
	}
	
	@Test
	void test_findByBrewerLike() {
		List<Beer> beers = repo.findByBrewerLike("Cinco Estrellas");
		assertNotNull(beers);
		assertEquals("Mahou", beers.get(0).getName());
	}
	
	@Test
	void test_queryByAbvInRange() {
		List<Beer> beers = repo.queryByAbvInRange(4.5f, 8.0f);
		assertNotNull(beers);
		assertEquals(3, beers.size()); // May throw a false
	}
	
	
	@Test
	void test_z_deleteById(){
		repo.deleteById(1);
		assertEquals(null, repo.findById(1));
	}
	

	// Not working, see note in controller
//	@Test
//	void test_queryByStyle() {
//		List<Beer> beers = repo.queryByStyle("Lag");
//		assertNotNull(beers);
//		assertEquals(4, beers.size());
//		
//	}
	
	
	
	
	


}
