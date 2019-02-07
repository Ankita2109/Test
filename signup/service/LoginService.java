package com.cts.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.signup.bean.User;
import com.cts.signup.repository.UserRepository;

@Service
public class LoginService {
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);

	}
}
