package com.skilldistillery.seltzertracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.seltzertracker.entities.Seltzer;

public interface SeltzerRepository extends JpaRepository<Seltzer, Integer> {

}
