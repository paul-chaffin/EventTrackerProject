package com.skilldistillery.seltzertracker.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.seltzertracker.entities.Coffee;


@SpringBootTest
class CoffeeRepositoryTest {

	@Autowired
	CoffeeRepository repo;
	
	@Test
	void test_findById() {
		Coffee c = repo.findById(2);
		assertNotNull(c);
		assertTrue(c.isCreamer());
		assertEquals(1, c.getSugarTbsp());
	}
	
	@Test
	void test_findAll() {
		List<Coffee> cL = repo.findAll();
		assertNotNull(cL);
		assertTrue(cL.size() > 0);
		assertEquals(4, cL.size());
	}
	
	@Test
	void test_queryByCreamerAndSugar() {
		List<Coffee> cL = repo.queryByCreamerAndSugar();
		assertNotNull(cL);
		assertTrue(cL.size() > 0);
		assertEquals(2, cL.size());
	}
	
	@Test
	void test_queryByNoCreamerAndNoSugar() {
		List<Coffee> cL = repo.queryByNoCreamerAndNoSugar();
		assertNotNull(cL);
		assertTrue(cL.size() > 0);
		assertEquals(2, cL.size());
	}
	
	@Test
	void test_findByOriginLike() {
		List<Coffee> cL = repo.findByOriginLike("Brazil");
		assertNotNull(cL);
		assertTrue(cL.size() > 0);
		assertEquals(2, cL.size());
	}
	
	

}
