package com.skilldistillery.seltzertracker.services;

import java.util.List;

import com.skilldistillery.seltzertracker.entities.Seltzer;

public interface SeltzerService {

	List<Seltzer> index();
	Seltzer showSeltzerById(int id);
	Seltzer createSeltzer(Seltzer newSeltzer);
	boolean deleteSeltzer(Integer id);
	Seltzer updateSeltzer(Integer id, Seltzer seltzer);
	
}
