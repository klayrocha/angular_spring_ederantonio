package com.ederantonio.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ederantonio.helpdesk.api.security.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);

}
