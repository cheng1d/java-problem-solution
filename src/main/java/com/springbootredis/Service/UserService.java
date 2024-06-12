package com.springbootredis.Service;

import com.springbootredis.Entity.User;

public interface UserService {
	public User create(User user, String userName);
	public User getByUserId(int id);
}
