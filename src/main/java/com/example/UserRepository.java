package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.mysema.query.types.Predicate;

public interface UserRepository extends JpaRepository<User, Long>, QueryDslPredicateExecutor<User> {

	public List<User> findAllByActiveIsTrue(Predicate predicate);
}
