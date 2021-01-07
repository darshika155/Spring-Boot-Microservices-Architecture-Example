package com.example.posts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.posts.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

	User findByUserId(Integer userId);

}
