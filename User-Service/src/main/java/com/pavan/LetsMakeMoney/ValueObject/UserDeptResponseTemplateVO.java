package com.pavan.LetsMakeMoney.ValueObject;

import com.pavan.LetsMakeMoney.Entity.UserPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDeptResponseTemplateVO {
	
	UserPojo userPojo;
	
	Department department;

}
