package com.swifta.felix.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("userService")
public class UserServiceImpl implements UserService {
 
 @Autowired
 private UserRepository userRepository;
 

 @Override
 public User findUserByEmail(String email) {
  return userRepository.findByEmail(email);
 }
 
 @Override
 public List<User> getAllUsers() {
  return userRepository.findAll();
 }
 
	/*
	 * @Override public User getUserById(long id) { return
	 * userRepository.findById(id); }
	 */

 @Override
 public void saveUser(User user) {
  //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
  //user.setActive(1);
  //Role userRole = roleRespository.findByRole("ADMIN");
  //user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
  userRepository.save(user);
 }
 
 public List<User> getSearchAll(String searchString) {
	    return userRepository.getAllUsersBySearchCriteria(searchString);

	}
 
 public int deleteUsers(Integer[] users) {
	   List<Integer> lst = Arrays.asList(users);
	     return userRepository.deleteUsers(lst);

	}
 
 public User getUser(User user) {
     return userRepository.findByEmail(user.getEmail());

}
 
 

}