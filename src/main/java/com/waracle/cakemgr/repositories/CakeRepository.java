package com.waracle.cakemgr.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.waracle.cakemgr.model.Cake;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Integer> {
	
	@Modifying
	@Transactional
	@Query("UPDATE Cake c set c.quantity=:quantity WHERE c.name=:name")
	void updateCakeQuantity(@Param("quantity")int quantity, @Param("name")String name);
	
	@Query("SELECT c from Cake c WHERE c.name=:name")
	Cake getCakeByName(@Param("name")String name);

}
