package com.example.posts.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.posts.VO.ResponseTemplateVO;
import com.example.posts.model.User;
import com.example.posts.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	@PostMapping("/user")
	public User getUser(@RequestBody User user) {
		log.info("Inside save user method of User Controller");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{userId}")
	@Transactional(timeout = 120)
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("userId") Integer userId) {
		log.info("Inside getUserWithDepartment method of User Controller" + request.getServerPort());
		return userService.getUserWithDepartment(userId);
	}
}
