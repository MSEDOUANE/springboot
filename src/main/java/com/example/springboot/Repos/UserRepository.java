package com.example.springboot.Repos;

import com.example.springboot.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> { 
    User findByName(String name);
    
}