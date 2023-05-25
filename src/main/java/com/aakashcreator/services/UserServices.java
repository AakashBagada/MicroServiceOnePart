package com.aakashcreator.services;

import java.util.List;

import com.aakashcreator.entity.UserEntity;

public interface UserServices {

	UserEntity saveUser(UserEntity userEntity);
	
    List<UserEntity> getAllUser();
    
    
    UserEntity getUserById(Integer uid);
    
    UserEntity updateUserById(UserEntity userEntity);
    
    UserEntity deleteUserById(Integer uid);
}
