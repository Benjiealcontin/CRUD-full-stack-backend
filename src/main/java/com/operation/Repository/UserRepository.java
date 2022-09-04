package com.operation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.operation.Model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	
	List<Users> findByid(int id);
	
	
	Users findById(int id);
}
