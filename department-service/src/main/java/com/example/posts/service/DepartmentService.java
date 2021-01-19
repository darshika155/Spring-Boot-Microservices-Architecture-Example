package com.example.posts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.posts.controller.DepartmentController;
import com.example.posts.model.Department;
import com.example.posts.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentService.class);

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department) {
		log.info("Inside save department method of Department Service");
		return departmentRepository.save(department);
	}

	public Department findDepartmentBydepartmentId(Integer departmentId) {
		// TODO Auto-generated method stub
		log.info("Inside find department by id method of Department Controller");
		return departmentRepository.findDepartmentBydepartmentId(departmentId);
	}

	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return (List<Department>) departmentRepository.findAll();
	}

	public void delete(Department department1) {
		// TODO Auto-generated method stub
		departmentRepository.delete(department1);
		
	}
}
