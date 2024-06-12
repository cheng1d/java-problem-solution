package com.springbootredis.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootredis.Entity.User;
import com.springbootredis.Service.UserServiceImpl;

@RestController
@RequestMapping("redis/v1")
public class UserController {

	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/get/{id}")

	public ResponseEntity<User> getByUserId(@PathVariable int id){
		User user = userService.getByUserId(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user){
		 User u = userService.create(user, user.getUsername());
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}
	
	
	
}
