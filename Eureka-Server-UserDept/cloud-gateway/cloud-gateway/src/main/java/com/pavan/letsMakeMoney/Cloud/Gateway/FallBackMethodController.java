package com.pavan.letsMakeMoney.Cloud.Gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FallBackMethodController {

	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMethod()
	{
		return "User Service is taking longer than expected"+"\n please try again later";
	}
	
	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMethod()
	{
		return "department Service is taking longer than expected"+"\n please try again later";
	}
}
