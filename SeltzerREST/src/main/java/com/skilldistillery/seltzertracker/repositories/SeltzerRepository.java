package com.skilldistillery.seltzertracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.seltzertracker.entities.Seltzer;

public interface SeltzerRepository extends JpaRepository<Seltzer, Integer> {

	public Seltzer findById(int id);
	public List<Seltzer> findAll();
	public void deleteById(Integer id);
	// delete by last entered?
	@SuppressWarnings("unchecked")
	public Seltzer save(Seltzer newSeltzer);

	
}
