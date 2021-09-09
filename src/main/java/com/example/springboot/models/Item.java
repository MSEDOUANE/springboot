package com.example.springboot.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NonNull
	private String name;
	@NonNull
	private String description;
	@NonNull
	private String price;
	@NonNull
	private Date add_date;
	@NonNull
	private String country_made;
	@NonNull
	private String image;
	@NonNull
	private String status;
	@NonNull
	private int rating;
	@NonNull
	private int approve;
	@NonNull
	private int category_id;
	@NonNull
	private int user_id;
	@NonNull
	private String tags;
}

