package com.pavan.letsMakeMoney.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.letsMakeMoney.Entity.Department;
import com.pavan.letsMakeMoney.Repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	
	
	public Department saveDepartmentDetails(Department department)
	{
		return departmentRepository.save(department);
	}
	
	public List<Department> findAllDepartmentDetails()
	{
		return departmentRepository.findAll();
				
	}
	
	public Department findByDepartmentId(Long departmentId)
	{
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
