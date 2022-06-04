package com.skilldistillery.seltzertracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.seltzertracker.entities.Beer;

public interface BeerRepository extends JpaRepository<Beer, Integer> {

	Beer findById(int id);

	List<Beer> findAll();

	void deleteById(Integer id);

	// delete by last entered?

	@SuppressWarnings("unchecked")
	Beer save(Beer newBeer);

	List<Beer> findByStyleLike(String pattern);

	// See note in controller
	@Query(value = "SELECT * FROM beer WHERE style LIKE '%:keyword%'", nativeQuery = true)
	List<Beer> queryByStyle(@Param("keyword") String keyword);

	List<Beer> findByBrewerLike(String pattern);

	@Query(value = "SELECT * FROM beer WHERE abv BETWEEN :low AND :high", nativeQuery = true)
	List<Beer> queryByAbvInRange(@Param("low") float low, @Param("high") float high);

}
