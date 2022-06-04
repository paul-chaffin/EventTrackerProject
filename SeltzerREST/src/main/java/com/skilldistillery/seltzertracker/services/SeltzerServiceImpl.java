package com.skilldistillery.seltzertracker.services;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.seltzertracker.entities.Seltzer;
import com.skilldistillery.seltzertracker.repositories.SeltzerRepository;

@Service
public class SeltzerServiceImpl implements SeltzerService{

	@Autowired
	SeltzerRepository repo;
	
	@Override
	public List<Seltzer> index() {
		return	repo.findAll();
	}

	@Override
	public Seltzer showSeltzerById(int id) {
		
		return repo.findById(id);
	}

	@Override
	public Seltzer createSeltzer(Seltzer newSeltzer) {
		return repo.save(newSeltzer);
	}

	@Override
	public boolean deleteSeltzer(Integer id) {
		 repo.deleteById(id);
		 boolean success = !repo.existsById(id);
		return success;
	}

	
	
}
