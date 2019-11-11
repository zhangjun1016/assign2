package com.mybatistest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mybatistest.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}
