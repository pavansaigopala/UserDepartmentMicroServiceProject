package com.pavan.LetsMakeMoney.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pavan.LetsMakeMoney.Entity.UserPojo;
import com.pavan.LetsMakeMoney.Service.UserService;
import com.pavan.LetsMakeMoney.ValueObject.UserDeptResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/saveUser")
	public UserPojo saveUser(@RequestBody UserPojo userPojo) {
		log.info("email::" + userPojo.getEmail());
		return userService.saveUser(userPojo);
	}

	@GetMapping("/allUsers")
	public List<UserPojo> getUserData() {
		return userService.getUserData();
	}

	@GetMapping("/{userId}")
	public UserDeptResponseTemplateVO getUserDepartmentDetailsById(@PathVariable("userId") Long userId) {
		
		UserDeptResponseTemplateVO userDeptResponseTemplateVO = userService.getUserDepartmentDetailsById(userId);

		log.info("Inside the controller");
		log.info("user Id:"+userId);

		return userDeptResponseTemplateVO;

	}
	
	

}
