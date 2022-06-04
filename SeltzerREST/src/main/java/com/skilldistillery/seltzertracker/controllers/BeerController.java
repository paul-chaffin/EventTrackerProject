package com.skilldistillery.seltzertracker.controllers;

import java.util.ArrayList;
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

import com.skilldistillery.seltzertracker.entities.Beer;
import com.skilldistillery.seltzertracker.services.BeerService;

@RequestMapping("api")
@RestController
public class BeerController {

	@Autowired
	private BeerService serv;

	@GetMapping("beers")
	public List<Beer> index() {
		return serv.index();
	}

	@GetMapping("beers/{id}")
	public Beer getBeerById(@PathVariable int id, HttpServletResponse res) {
		Beer b = new Beer();
		try {
			b = serv.showBeerById(id);
			res.setStatus(200);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
		}
		return b;
	}

	@PostMapping("beers")
	public Beer createNewSeltzer(@RequestBody Beer newBeer, HttpServletResponse res) {
		Beer nB = new Beer();
		try {
			nB = serv.createBeer(newBeer);
			res.setStatus(201);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(415);
		}
		return nB;
	}

	@DeleteMapping("beers/{id}")
	public void deleteBeer(@PathVariable Integer id, HttpServletResponse res) {
		if (serv.deleteBeer(id)) {
			res.setStatus(200);
		} else {
			res.setStatus(404);
		}
		System.out.println("Deleted!");
	}

	@PutMapping("beers/{id}")
	public Beer updateBeer(@PathVariable Integer id, @RequestBody Beer beer, HttpServletResponse res) {
		try {
			serv.updateBeer(id, beer);
			res.setStatus(200);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
		}
		return serv.showBeerById(id);
	}

	@GetMapping("beers/style/{pattern}")
	public List<Beer> findByStyleLike(@PathVariable String pattern, HttpServletResponse res) {
		List<Beer> beers = new ArrayList<>();
		try {
			beers =  serv.findByStyleLike(pattern);
			res.setStatus(200);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return beers;
	}

	// This method refuses to return a non-empty list, and I have no idea why. I traced it all the way back piece by piece and everything works.
//	@GetMapping("beers/search/style/{keyword}")
//	public List<Beer> getBeersByStyleSearch(@PathVariable String keyword, HttpServletResponse res) {
//		List<Beer> beers = new ArrayList<>();
//		try {
//			beers = serv.showByStyleSearch(keyword);
//			res.setStatus(200);
//			System.out.println(beers);
//		} catch (Exception e) {
//			e.printStackTrace();
//			res.setStatus(400);
//		}
//		return beers;
//	}

	@GetMapping("beers/abv/{low}/{high}")
	public List<Beer> queryByAbvInRange(@PathVariable float low, @PathVariable float high, HttpServletResponse res) {
		return serv.queryByAbvInRange(low, high);
	}

	@GetMapping("beers/brewer/{pattern}")
	public List<Beer> findByBrewerLike(@PathVariable String pattern, HttpServletResponse res) {
		return serv.findByBrewerLike(pattern);
	}



}
