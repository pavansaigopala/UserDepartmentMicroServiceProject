package com.pavan.LetsMakeMoney.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.pavan.LetsMakeMoney.Entity.UserPojo;
import com.pavan.LetsMakeMoney.Repository.UserRepository;
import com.pavan.LetsMakeMoney.ValueObject.Department;
import com.pavan.LetsMakeMoney.ValueObject.UserDeptResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;

	public UserPojo saveUser(UserPojo userPojo) {
		
		log.info("FirstName::"+userPojo.getFirstName());
		return userRepository.save(userPojo);
	}

	public List<UserPojo> getUserData() {
		return userRepository.findAll();
	}

	public UserPojo findUserById(Long userId) {

		return userRepository.findByUserId(userId);
	}

	public UserDeptResponseTemplateVO getUserDepartmentDetailsById(Long userId) {

		UserDeptResponseTemplateVO userDeptResponseTemplateVO = new UserDeptResponseTemplateVO();
		
		UserPojo userPojo =  userRepository.findByUserId(userId);
		
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + userPojo.getDepartmentId(), Department.class);

		log.info("------------------------ UserService ------------------");
		
		userDeptResponseTemplateVO.setUserPojo(userPojo);
		userDeptResponseTemplateVO.setDepartment(department);
		
		log.info("User Name::"+userDeptResponseTemplateVO.getUserPojo().getFirstName());
		log.info("Department Name::"+userDeptResponseTemplateVO.getDepartment().getDepartmentName());
		
		return userDeptResponseTemplateVO;
	}
	
	
}
