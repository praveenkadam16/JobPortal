package com.portal.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.jobportal.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>{
	
}