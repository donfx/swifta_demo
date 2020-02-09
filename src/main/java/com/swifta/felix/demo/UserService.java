package com.swifta.felix.demo;

import java.util.List;

public interface UserService {
	  
	 public User findUserByEmail(String email);
	 
	 public void saveUser(User user); //save user
	 
	 public List<User> getAllUsers();
	 
	 //public User editUser(User user);
	 
	 public User getUser(User user);
	 
	 public List<User> getSearchAll(String searchItem);
	 
	
	 
	 public int deleteUsers(Integer[] items);
	
	 
	 //public User getUserById(long id);
}
