package com.aakashcreator.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aakashcreator.entity.UserEntity;
import com.aakashcreator.exception.ResourceNotFoundException;
import com.aakashcreator.repository.UserRepository;
import com.aakashcreator.services.UserServices;

@Service
public class UserServiceImpl implements UserServices {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserEntity saveUser(UserEntity userEntity) {
		UserEntity user=userRepository.save(userEntity);
		
		return user;
		
	}

	@Override
	public List<UserEntity> getAllUser() {
		List<UserEntity> users=userRepository.findAll();
		return users;
	}

	@Override
	public UserEntity getUserById(Integer uid) {
		
		UserEntity user=userRepository.findById(uid).orElseThrow(() -> new ResourceNotFoundException("user is not present for this uid :"+uid));
		
		return user;
	}

	@Override
	public UserEntity deleteUserById(Integer uid) {
		UserEntity user=userRepository.findById(uid).get();
		userRepository.deleteById(uid);
		return user;
	}

	@Override
	public UserEntity updateUserById(UserEntity userEntity) {
		UserEntity user=userRepository.save(userEntity);
		
		return user;
	}

}
