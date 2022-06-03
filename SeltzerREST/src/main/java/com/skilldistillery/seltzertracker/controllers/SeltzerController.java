package com.skilldistillery.seltzertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
