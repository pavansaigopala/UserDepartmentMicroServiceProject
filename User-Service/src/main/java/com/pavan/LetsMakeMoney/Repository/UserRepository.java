package com.pavan.LetsMakeMoney.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pavan.LetsMakeMoney.Entity.UserPojo;

@Repository
public interface UserRepository extends JpaRepository<UserPojo, Long> {

	UserPojo findByUserId(Long userId);


}
