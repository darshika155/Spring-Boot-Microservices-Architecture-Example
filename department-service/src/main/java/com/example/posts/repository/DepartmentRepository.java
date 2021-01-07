package com.example.posts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.posts.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer>{

	Department findDepartmentBydepartmentId(Integer departmentId);
}
