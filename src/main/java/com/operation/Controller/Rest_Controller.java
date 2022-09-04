package com.operation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.operation.Exception.UserNotFoundException;
import com.operation.Model.Users;
import com.operation.Repository.UserRepository;
import com.operation.Service.Services;

@RestController
@CrossOrigin("http://localhost:3000")
public class Rest_Controller {

	
	@Autowired
	private Services service;
	
	@Autowired
	private UserRepository repo;
	
	
	@RequestMapping("/")
	public String home() {
		return "Home";
		
	}
	// Add user 
	@PostMapping("/add")

    Users newUser(@RequestBody Users newUser) {
        return repo.save(newUser);
    }
	
	// Retrieve data from database
    @GetMapping("/users")
    List<Users> getAllUsers() {
        return repo.findAll();
    }
	
    
	// Retrieve data by ID
    @GetMapping("/user/{id}")
    Users getUserById(@PathVariable int id) {
        return repo.findById(id);
    }
	
	
	   @DeleteMapping("/user/{id}")
	    String deleteUser(@PathVariable Integer id){
	        if(!repo.existsById(id)){
	            throw new UserNotFoundException(id);
	        }
	        repo.deleteById(id);
	        return  "User with id "+id+" has been deleted success.";
	    }
	
	//https://github.com/Benjiealcontin/Simple-CRUD-Fullstack.git
	
		@PutMapping("/UpdateData/{id}")
		public String Updatedata(@RequestBody Users user, @PathVariable int id) {
			Users myUpdateData = service.findbyid(id);
			myUpdateData.setFirstname(user.getFirstname());
			myUpdateData.setLastname(user.getLastname());
			myUpdateData.setAge(user.getAge());
			service.Updatedata(myUpdateData);
			return "success";
			
		}
}
