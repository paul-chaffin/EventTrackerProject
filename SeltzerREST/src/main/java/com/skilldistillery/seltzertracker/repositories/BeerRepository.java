package com.skilldistillery.seltzertracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.seltzertracker.entities.Beer;

public interface BeerRepository extends JpaRepository<Beer, Integer> {

	public Beer findById(int id);
	
	public List<Beer> findAll();
	
	public void deleteById(Integer id);
	
	// delete by last entered?
	
	@SuppressWarnings("unchecked")
	public Beer save(Beer newBeer);
	
	public List<Beer> findByStyleLike(String pattern);
	
	@Query(value="SELECT * FROM beer WHERE abv BETWEEN :low AND :high", nativeQuery=true)
	List<Beer> queryByAbvInRange(@Param("low")float low, @Param("high")float high);
	
	
}
