package com.swifta.felix.demo;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

@Controller
public class UserController {

 @Autowired
 private UserService userService;
 
 @Autowired
 private UserRepository userRepo;
 
 @RequestMapping(value= {"/login"}, method=RequestMethod.GET)
 public ModelAndView login() {
  ModelAndView model = new ModelAndView();
  
  model.setViewName("user/login");
  return model;
 }
 
	/*
	 * public UserController(UserRepository userRepo) { this.userRepo = userRepo; }
	 */
 
 @RequestMapping(value= {"/", "/index"}, method=RequestMethod.GET)
 public String Homepage(Model model) {
     model.addAttribute("users", userRepo.findAll());
     System.out.println("Total number of records available: " + userRepo.findAll().size() );
     return "index";
 }
 
 
 @GetMapping("edit/{id}")
 public String showUpdateForm(@PathVariable("id") long id, Model model) {
	 //User roomEntity = userRepo.getOne(id); // JPArepository
     User user = userRepo.findById(id).get(); // For CRUDrepository and JPArepository
     model.addAttribute("user", user);
     return "update";
 }
 
 
 @PostMapping("update/{id}")
 public ModelAndView updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result) {
	 
	 ModelAndView model = new ModelAndView();
     if (result.hasErrors()) {
    	 user.setId(id);
    	 model.setViewName("update");
         return model;
     }

     userRepo.save(user);
     
     model.addObject("msg", "User Profile Updated Successfully!");
     model.addObject("users", userRepo.findAll());
     model.setViewName("index");
     return model;
     
   
 }
 
 
 @PostMapping("search")
 public String searchUser(String item,
     Model model) {
     System.out.println(item);
     //userRepo.save(user);
     model.addAttribute("users", userService.getSearchAll(item));
     return "index";
 }
 
 @PostMapping("deleteUser")
 public ModelAndView deleteUser(Integer[] userid) {
	 ModelAndView model = new ModelAndView();
     System.out.println(userid);
     
     int i =userService.deleteUsers(userid);
     System.out.println("Number of records deleted: " +i);
     model.addObject("msg", "Deletion Successful....!");
     model.addObject("users", userRepo.findAll());
     System.out.println("Total number of records available: " + userRepo.findAll().size() );
     model.setViewName("index");
     
     return model;
 }
 
	/*
	 * public ModelAndView index() { ModelAndView model = new ModelAndView();
	 * 
	 * model.setViewName("index"); return model; }
	 */
 
 @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
 public ModelAndView signup() {
  ModelAndView model = new ModelAndView();
  User user = new User();
  model.addObject("user", user);
  model.setViewName("signup");
  
  return model;
 }
 

 
 @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
 public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
  ModelAndView model = new ModelAndView();
  User userExists = userService.findUserByEmail(user.getEmail());
  
  if(userExists != null) {
   bindingResult.rejectValue("email", "error.user", "Email already exists!");
  }
  if(bindingResult.hasErrors()) {
   model.setViewName("signup");
  } else {
   userService.saveUser(user);
   model.addObject("msg", "User Profile Created Successfully!");
   
   userRepo.save(user);
   model.addObject("users", userRepo.findAll());
   model.setViewName("index");
   return model;
  
  }
  
  return model;
 }
 

 
	/*
	 * @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET) public
	 * ModelAndView accessDenied() { ModelAndView model = new ModelAndView();
	 * model.setViewName("errors/access_denied"); return model; }
	 */
 
 
}