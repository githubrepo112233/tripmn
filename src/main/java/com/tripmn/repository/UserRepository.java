package com.tripmn.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.tripmn.entity.User;
import com.tripmn.enums.UserType;

public interface UserRepository extends Repository<User, Long>,
		BaseRepository<User, Long>, UserRepositoryCustom {
	
	public User findByEmailId(String emailId);
	public User findByMobileNumber(String mobileNumber);
	public List<User> findByUserType(UserType userType);
	public User findByUserName(String userName);

}
