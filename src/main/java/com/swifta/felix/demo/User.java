package com.swifta.felix.demo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
 
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private long id;
 

 
 @Column(name = "firstname")
 private String firstname; 
 
 @Column(name = "lastname")
 private String lastname;
 
 @Column(name = "email")
 private String email;
 
 @Column(name = "phone")
 private String phone;
 
 @Column(name = "gender")
 private String gender;
 
 @Column(name = "dob")
 private String dob;
 
 @Column(name = "nationality")
 private String nationality;
 

 
 @Column(name = "active")
 private int active;
 
 @Column(name = "role")
 private String role;
 
	/*
	 * @ManyToMany(cascade=CascadeType.ALL)
	 * 
	 * @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"),
	 * inverseJoinColumns=@JoinColumn(name="role_id")) private Set<Role> roles;
	 */
 public long getId() {
  return id;
 }

 public void setId(long id) {
  this.id = id;
 }



 public String getFirstname() {
  return firstname;
 }

 public void setFirstname(String firstname) {
  this.firstname = firstname;
 }

 public String getLastname() {
  return lastname;
 }

 public void setLastname(String lastname) {
  this.lastname = lastname;
 }


 
 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }
 
 public String getPhone() {
	  return phone;
	 }

	 public void setPhone(String phone) {
	  this.phone = phone;
	 }
	 
	 
 public String getGender() {
	  return gender;
	 }

	 public void setGender(String gender) {
	  this.gender = gender;
	 }	 
		 
 public String getDob() {
	  return dob;
	 }

 public void setDob(String dob) {
  this.dob = dob;
 }	
 
 public String getNationality() {
	  return nationality;
	 }

	 public void setNationality(String nationality) {
	  this.nationality = nationality;
	 }			 

 public int getActive() {
  return active;
 }

 public void setActive(int active) {
  this.active = active;
 }

 public String getRole() {
	  return role;
	 }

	 public void setRole(String role) {
	  this.role = role;
	 }			 

	 
	/*
	 * public Set<Role> getRoles() { return roles; }
	 * 
	 * public void setRoles(Set<Role> roles) { this.roles = roles; }
	 */
}