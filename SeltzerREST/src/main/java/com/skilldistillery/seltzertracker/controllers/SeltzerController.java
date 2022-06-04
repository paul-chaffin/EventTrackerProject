package com.skilldistillery.seltzertracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.seltzertracker.entities.Seltzer;
import com.skilldistillery.seltzertracker.services.SeltzerService;

@RequestMapping("api")
@RestController
public class SeltzerController {

	@Autowired
	private SeltzerService serv;
	
	@GetMapping("seltzers")
	public List<Seltzer> index(){
		return serv.index();
	}
	
	@GetMapping("seltzers/{id}")
	public Seltzer getSeltzerById(@PathVariable int id, HttpServletResponse res) {
		Seltzer s = new Seltzer();
		try {
			s = serv.showSeltzerById(id);
			res.setStatus(200);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
		}
		return s;
	}
	
	@PostMapping("seltzers")
	public Seltzer createNewSeltzer(@RequestBody Seltzer newSeltzer, HttpServletResponse res) {
		Seltzer nS = new Seltzer();
		try {
			nS = serv.createSeltzer(newSeltzer);
			res.setStatus(201);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(415);
		}
		return nS;
	}
	
	@DeleteMapping("seltzers/{id}")
	public void deleteSeltzer(@PathVariable Integer id, HttpServletResponse res) {
		if (serv.deleteSeltzer(id)) {
			res.setStatus(200);
		} else {
			res.setStatus(404);
		}
		System.out.println("Deleted!");
	}
	
	@PutMapping("seltzers/{id}")
	public Seltzer updateSeltzer(@PathVariable Integer id, @RequestBody Seltzer seltzer, HttpServletResponse res) {
		try {
			serv.updateSeltzer(id, seltzer);
			res.setStatus(200);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
		}
		return serv.showSeltzerById(id);
	}
	
}
