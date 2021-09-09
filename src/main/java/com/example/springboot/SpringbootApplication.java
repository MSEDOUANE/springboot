package com.example.springboot;

import java.util.ArrayList;
import java.util.List;

import com.example.springboot.Repos.CarouselRepo;
import com.example.springboot.Repos.ItemsRepo;
import com.example.springboot.Repos.UserRepository;
import com.example.springboot.Services.UserService;
import com.example.springboot.models.Carousel;
import com.example.springboot.models.Item;
import com.example.springboot.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@SpringBootApplication
@RestController
public class SpringbootApplication {


	@Autowired
	private CarouselRepo repository;
	@Autowired
	private UserService userRepos;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/home")
	public ResponseEntity<Iterable<Carousel>> getMethod() {
		Iterable<Carousel> iterator = repository.findAll();
		List<Carousel> result = new ArrayList<Carousel>();
		iterator.forEach(result::add);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/home").allowedOrigins("http://localhost:3000");
			}
		};
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
