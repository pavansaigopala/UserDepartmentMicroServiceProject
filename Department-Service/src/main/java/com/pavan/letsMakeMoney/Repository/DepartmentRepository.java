package com.pavan.letsMakeMoney.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pavan.letsMakeMoney.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	
	Department findByDepartmentId(Long departmentId);
}
