package com.aakashcreator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aakashcreator.entity.UserEntity;
import com.aakashcreator.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServices userServices;
	
	@PostMapping("/addUser")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity) {
		
		UserEntity user=userServices.saveUser(userEntity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
		
		
	}
	
	@GetMapping("/getUserByID/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Integer uid){
		
		UserEntity user=userServices.getUserById(uid);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserEntity>> getAllUser(){
	
	   List<UserEntity>	 users=userServices.getAllUser();
		
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public ResponseEntity<UserEntity> deleteUser(@PathVariable("id") Integer uid){
		UserEntity user=userServices.getUserById(uid);
		userServices.deleteUserById(uid);
		
		return ResponseEntity.status(HttpStatus.OK).body(user); 
		
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity){
		
		UserEntity user=userServices.saveUser(userEntity);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
