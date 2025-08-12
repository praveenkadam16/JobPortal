package com.portal.jobportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.jobportal.entity.UsersType;
import com.portal.jobportal.repository.UsersTypeRepository;

@Service
public class UsersTypeService {
		private final UsersTypeRepository usersTypeRepository;
		@Autowired
		public UsersTypeService(UsersTypeRepository usersTypeRepository) {
			this.usersTypeRepository=usersTypeRepository;
		}
		public List<UsersType> getAll(){
			return usersTypeRepository.findAll();
		}
}
