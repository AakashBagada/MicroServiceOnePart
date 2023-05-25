package com.aakashcreator.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aakashcreator.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>  {

	Optional<UserEntity> findById(Integer uid);

	List<UserEntity> findAll();

}
