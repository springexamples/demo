package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysema.query.types.Predicate;

@RestController("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@ResponseBody
	@RequestMapping(path = "/api/users/active", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Iterable<User>> getActiveUsers(@QuerydslPredicate Predicate predicate) {

		return new ResponseEntity<>(userRepo.findAllByActiveIsTrue(predicate), HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Iterable<User>> getUsers(@QuerydslPredicate Predicate predicate) {

		return new ResponseEntity<>(userRepo.findAll(predicate), HttpStatus.OK);
	}
}
