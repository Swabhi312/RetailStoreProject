package com.coder.cruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coder.cruddemo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
   
}
