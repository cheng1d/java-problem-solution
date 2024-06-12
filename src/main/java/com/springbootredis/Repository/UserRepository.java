package com.springbootredis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootredis.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
