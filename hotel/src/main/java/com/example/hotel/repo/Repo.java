package com.example.hotel.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.UserEntity;

@Repository
public interface Repo extends CrudRepository<UserEntity,Integer>{
	
	List<UserEntity> findByEmail(String email);
	
	UserEntity findByUsername(String username);

	//String getEmail();
}
