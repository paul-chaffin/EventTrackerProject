package com.skilldistillery.seltzertracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.seltzertracker.entities.Coffee;
import com.skilldistillery.seltzertracker.entities.Seltzer;
import com.skilldistillery.seltzertracker.services.CoffeeService;

@RequestMapping("api")
@RestController
public class CoffeeController {

	@Autowired
	private CoffeeService serv;
	
	@GetMapping("coffees")
	public List<Coffee> index(){
		return serv.index();
	}
	
	@GetMapping("coffees/{id}")
	public Coffee getCoffeeById(@PathVariable int id, HttpServletResponse res) {
		Coffee c = new Coffee();
		try {
			c = serv.showCoffeeById(id);
			res.setStatus(200);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
		}
		return c;
	}
	
	@PostMapping("coffees")
	public Coffee createNewCoffee(@RequestBody Coffee newCoffee, HttpServletResponse res) {
		Coffee nC = new Coffee();
		try {
			nC = serv.createCoffee(newCoffee);
			res.setStatus(201);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(415);
		}
		return nC;
	}
	
	@DeleteMapping("coffees/{id}")
	public void deleteCoffee(@PathVariable Integer id, HttpServletResponse res) {
		if (serv.deleteCoffee(id)) {
			res.setStatus(200);
		} else {
			res.setStatus(404);
		}
		System.out.println("Deleted!");
	}
	
}
