package com.example.springboot.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.var;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.example.springboot.Repos.CategorieRepo;
import com.example.springboot.Repos.UserRepository;
import com.example.springboot.models.Categorie;
import com.example.springboot.models.User;

@Service
public class CategorieService  {

	@Autowired
	private CategorieRepo categorieRepo;

	public Iterable<Categorie> findAll() {


		return categorieRepo.findAll();
	}

	public Long count() {

		return categorieRepo.count();
	}

	public void deleteById(Long userId) {

		categorieRepo.deleteById(userId);
	}


}

