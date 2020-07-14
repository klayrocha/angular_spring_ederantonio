package com.ederantonio.helpdesk.api.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ederantonio.helpdesk.api.security.entity.User;
import com.ederantonio.helpdesk.api.repository.UserRepository;
import com.ederantonio.helpdesk.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByEmail(String email) {
		
		return this.userRepository.findByEmail(email);
	}

	@Override
	public User createOrUpdate(User user) {
		
		return this.userRepository.save(user);
	}

	@Override
	public User findById(String id) {
		
		//return this.userRepository.findOne(id);
		Optional<User> findById = this.userRepository.findById(id);
		return findById.get();
	}

	@Override
	public void delete(String id) {
		this.userRepository.deleteById(id);
		
	}

	@Override
	public Page<User> findAll(int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.userRepository.findAll(pages);
	}

}
