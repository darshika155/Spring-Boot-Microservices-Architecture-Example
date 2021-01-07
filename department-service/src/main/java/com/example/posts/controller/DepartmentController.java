package com.example.posts.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.example.posts.model.Department;
import com.example.posts.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	
//	@Bean
//	public ClassLoaderTemplateResolver secondaryTemplateResolver() {
//	    ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
//	    secondaryTemplateResolver.setPrefix("templates/");
//	    secondaryTemplateResolver.setSuffix(".html");
//	    secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
//	    secondaryTemplateResolver.setCharacterEncoding("UTF-8");
//	    secondaryTemplateResolver.setOrder(1);
//	    secondaryTemplateResolver.setCheckExistence(true);
//	        
//	    return secondaryTemplateResolver;
//	}
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private HttpServletRequest request;
	
	@PostMapping("/department")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Inside save department method of Department Controller");
		return departmentService.saveDepartment(department);
	}
	
//	@GetMapping("/index")    
//	public ModelAndView index(@ModelAttribute("department") Department department)  
//	{    
//		ModelAndView modelAndView = new ModelAndView();
//	    modelAndView.setViewName("index");
//	    return modelAndView;  
//	}    
	
	@GetMapping("/")
	public List<Department> getAllDepartments() {
		log.info("Inside find department by id method of Department Controller");
		return departmentService.getAllDepartments();
	}
	
	@GetMapping("/{departmentId}")
	public Department findDepartmentById(@PathVariable("departmentId") Integer departmentId) {
		log.info("Inside find department by id method of Department Controller" + request.getServerPort());
		return departmentService.findDepartmentBydepartmentId(departmentId);
	}

}
