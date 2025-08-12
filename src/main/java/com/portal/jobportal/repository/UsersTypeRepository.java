package com.portal.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.jobportal.entity.UsersType;

public interface UsersTypeRepository extends JpaRepository<UsersType, Integer> {
	
}
