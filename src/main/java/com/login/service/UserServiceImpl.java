package com.login.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.model.Role;
import com.login.model.User;
import com.login.repository.UserRepository;
import com.login.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto userRegistrationDto) {
		User user = new User(userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
				userRegistrationDto.getEmail(), userRegistrationDto.getPassword(),
				Arrays.asList(new Role("ROLE_USER")));

		return userRepository.save(user);
	}

}
