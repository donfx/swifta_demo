package com.swifta.felix.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class UsersRestController {

    

    @Autowired
	private UserService userService;
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(path="/users", method=RequestMethod.GET)
	public ResponseEntity getAllUsers(){
    	return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);		
	}
    
    @RequestMapping(path="/edit/{id}", method=RequestMethod.PUT)
 	public ResponseEntity editUser(@PathVariable Integer id, @RequestBody User user){
    	user.setId(id);
    	userService.saveUser(user);
    	return new ResponseEntity(userService.getUser(user), HttpStatus.OK);
    	
    	
 	}
    
    @RequestMapping(path="/search", method=RequestMethod.GET)
 	public ResponseEntity searchUser(@RequestBody String item){
 		return new ResponseEntity(userService.getSearchAll(item), HttpStatus.OK);
 	}
    
    
    
    @RequestMapping(path="/delete", method=RequestMethod.DELETE)
 	public ResponseEntity  deleteUsers(@RequestBody Integer[] product){
 		int num_deleted = userService.deleteUsers(product);
 		return new ResponseEntity(num_deleted, HttpStatus.OK);
 	}
    
    @RequestMapping(path="/create", method = RequestMethod.POST)
 	public ResponseEntity createUser (@RequestBody User user){	
    	 userService.saveUser(user);
    	 return new ResponseEntity(userService.getUser(user), HttpStatus.OK);
 	}
    
    
	/*
	 * @RequestMapping(value = "/user/{id}", method = RequestMethod.GET) public User
	 * getUserById(@PathVariable("id") long id){ return userService.getUserById(id);
	 * }
	 */
    
}
