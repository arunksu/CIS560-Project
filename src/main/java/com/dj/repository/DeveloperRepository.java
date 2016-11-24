package com.dj.repository;

import com.dj.model.Developer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DJ on 11/23/16.
 */

@Repository
public interface DeveloperRepository extends CrudRepository<Developer,Integer> {
	
}
