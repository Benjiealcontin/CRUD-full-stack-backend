package com.operation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.operation.Model.Users;
import com.operation.Repository.UserRepository;

@Service
public class Services {
	
	@Autowired
	private UserRepository repo;
	
	// add user
	public Users adduser(Users user) {
		return repo.save(user);
		
	}
	
	// retrieve data from database
	public List<Users> showdata() {
		return (List<Users>)repo.findAll();
		
	}
	
	// retrieve data by Id
	public List<Users> getById(int id) {
		return repo.findByid(id);
		
	}
	

	//Update
	public Users findbyid(int id) {
		return repo.findById(id);
		
	}
	
	public Users Updatedata(Users user) {
		Users data = repo.findById(user.getId());
		data.setFirstname(user.getFirstname());
		data.setLastname(user.getLastname());
		data.setAge(user.getAge());
		return repo.save(data);
		
	}
	
	//Delete data
	public String delete(int id) {
		repo.deleteById(id);
		return "successfully deleted id number : " + id;
		
	}

}
