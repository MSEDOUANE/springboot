package com.example.springboot;

import java.util.ArrayList;
import java.util.List;

import com.example.springboot.Repos.ItemsRepo;
import com.example.springboot.Repos.UserRepository;
import com.example.springboot.Services.UserService;
import com.example.springboot.models.Item;
import com.example.springboot.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@SpringBootApplication
@RestController
public class SpringbootApplication {

	@Autowired
	private ItemsRepo repository;
	@Autowired
	private UserService userRepos;
	@GetMapping(value = "/hello")
	public Iterable<Item> getMethod() {
		Iterable<Item> iterator = repository.findAll();
		List<Item> result = new ArrayList<Item>();
		iterator.forEach(result::add);
		return result;
	}

	@RequestBody
	@GetMapping(value = SecurityConstants.SIGN_UP_URL)
	public int UserSignup(User user) {
		
		return userRepos.saveDto(user);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	@Bean
	CommandLineRunner runner() {
		return args -> {

		//userRepos.saveDto(new User("user1","123456","sed@mail.com" ));

		};}
}
