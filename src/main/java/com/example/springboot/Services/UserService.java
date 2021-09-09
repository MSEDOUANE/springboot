package com.example.springboot.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.var;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.example.springboot.Repos.UserRepository;
import com.example.springboot.models.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {

		Iterable<User> it = userRepository.findAll();

		ArrayList<User> users = new ArrayList<User>();
		it.forEach(e -> users.add(e));

		return users;
	}

	public Long count() {

		return userRepository.count();
	}

	public void deleteById(Long userId) {

		userRepository.deleteById(userId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(rollbackOn = Exception.class)
	public int saveDto(User userDto) {
		userDto.setPassword(passwordEncoder().encode(userDto.getPassword()));

		return userRepository.save(new User(userDto.getName(), userDto.getPassword(), userDto.getEmail())).getId();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}