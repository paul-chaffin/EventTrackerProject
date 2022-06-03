package com.skilldistillery.seltzertracker.services;

import java.util.List;

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

	
	
}
