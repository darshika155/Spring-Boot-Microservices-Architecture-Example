package com.example.posts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.posts.VO.Department;
import com.example.posts.VO.ResponseTemplateVO;
import com.example.posts.model.User;
import com.example.posts.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Integer userId) {
		// TODO Auto-generated method stub
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		Department department = restTemplate.getForObject("http://department-service/departments/"+user.getDepartmentId(), Department.class);
		responseTemplateVO.setUser(user);
		responseTemplateVO.setDepartment(department);
		return responseTemplateVO;
	}

}
