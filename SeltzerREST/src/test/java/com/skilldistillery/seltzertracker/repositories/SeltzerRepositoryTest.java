package com.skilldistillery.seltzertracker.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.seltzertracker.entities.Seltzer;

@SpringBootTest
class SeltzerRepositoryTest {

	@Autowired
	private SeltzerRepository repo;
	
	@Test
	void test_findById() {
		Seltzer s = repo.findById(1);
		assertNotNull(s);
		assertEquals(32, s.getOunces());
	}
	
	@Test
	void test_findAll() {
		List<Seltzer> sL = repo.findAll();
		assertNotNull(sL);
		assertEquals(1, sL.size());
	}

}
