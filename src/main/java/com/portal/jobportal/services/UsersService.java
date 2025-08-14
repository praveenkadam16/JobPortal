package com.portal.jobportal.services;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.jobportal.entity.Users;
import com.portal.jobportal.repository.UsersRepository;
@Service
public class UsersService {
		private final UsersRepository usersRepository;
		@Autowired
		public UsersService(UsersRepository usersRepository) {
			this.usersRepository=usersRepository;
		}
		
		public Users addNew(Users users) {
			users.setActive(true);
			users.setRegistrationDate(new Date(System.currentTimeMillis()));
			return usersRepository.save(users);
			
		}
}
