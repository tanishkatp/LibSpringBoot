package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.domain.Login;

@Service
public interface LoginDao extends JpaRepository<Login, Integer>{
	
	@Query(value = "SELECT * FROM Login WHERE userName= ?1 AND password= ?2", nativeQuery = true)
	List<Login> UserExist(String country,String lastName);
}
