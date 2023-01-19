package com.yash.yota.repository;
/*
 * Repository layer will communicate with DB layer
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.yota.model.ParentTechnology;


public interface ParentTechnologyRepository extends JpaRepository<ParentTechnology, Long>{

	boolean deleteByName(String name);

	ParentTechnology getByName(String name);

	List<ParentTechnology> getByNameContaining(String keyword);

}
