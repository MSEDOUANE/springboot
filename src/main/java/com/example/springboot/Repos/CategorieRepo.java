package com.example.springboot.Repos;

import java.util.List;

import com.example.springboot.models.Categorie;
import com.example.springboot.models.Item;

import org.springframework.data.repository.CrudRepository;

public interface CategorieRepo extends CrudRepository<Categorie, Long> {


}
