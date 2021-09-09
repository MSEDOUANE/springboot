package com.example.springboot.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Table(name = "categories")
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NonNull
	private long parent;
	@NonNull
	private String description;
	@NonNull
	private String ordering;
	@NonNull
	private String visibility;
	@NonNull
	private int allow_comments;
	@NonNull
	private int allow_ads;
}

