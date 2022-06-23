package com.pavan.letsMakeMoney.Controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.letsMakeMoney.Entity.Department;
import com.pavan.letsMakeMoney.Service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	// save department data
	
	@PostMapping("/save")
	public Department saveDepartmentDetails(@RequestBody Department department)
	{
		return departmentService.saveDepartmentDetails(department);
	}
	
	
	// get department data
	
	@GetMapping("/AllDept")
	public List<Department> getAllDepartmentDetails()
	{
		return departmentService.findAllDepartmentDetails();
	}
	
	@GetMapping("/{id}")
	public Department findByDepartmentId(@PathVariable("id") Long departmentId)
	{
		return departmentService.findByDepartmentId(departmentId);
	}
	
}
