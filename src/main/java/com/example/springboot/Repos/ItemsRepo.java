package com.example.springboot.Repos;

import java.util.List;

import com.example.springboot.models.Item;

import org.springframework.data.repository.CrudRepository;

public interface ItemsRepo extends CrudRepository<Item, Long> {


}
