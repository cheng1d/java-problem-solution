package com.springbootredis.Service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.springbootredis.Entity.User;
import com.springbootredis.Repository.UserRepository;

//import jakarta.persistence.Cacheable;

@Service
public class UserServiceImpl implements UserService {

	 @Autowired
	 UserRepository userRepository;
	 
	 @Autowired
	 private RedisTemplate<String, Object> redisTemplate;
	 

	@Override
	public User create(User user, String username) {	
		redisTemplate.opsForValue().set(username, user);
		 System.out.println("Data:");
		return userRepository.save(user);
	}
    
	

	@Override
   
	public User getByUserId(int id) {
      User user= userRepository.findById(id).get();
      System.out.println("Data:");
      System.out.println("Data:" + user.getUsername());
      System.out.println("cache Data:" + getData(user.getUsername()));
	  return user;
	}
	
	
	public Object getData(String key) {
	    return redisTemplate.opsForValue().get(key);
	}
}
