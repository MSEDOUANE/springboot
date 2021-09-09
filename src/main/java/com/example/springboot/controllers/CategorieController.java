package com.example.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.example.springboot.Services.CategorieService;
import com.example.springboot.models.Categorie;
import com.example.springboot.models.User;

@RestController
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categorie")
    public ResponseEntity<Iterable<Categorie>> allCategories() {

        List<Categorie> tutorials = new ArrayList<Categorie>();
        categorieService.findAll().forEach(tutorials::add);

        return new ResponseEntity<>(tutorials, HttpStatus.OK) ;
    }

    @GetMapping("/categorie/count")
    public Long count() {

        return categorieService.count();
    }

    @DeleteMapping("/categorie/{id}")
    public void delete(@PathVariable String id) {

        Long userId = Long.parseLong(id);
        categorieService.deleteById(userId);
    }
}