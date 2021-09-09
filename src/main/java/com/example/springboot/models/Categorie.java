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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getParent() {
		return parent;
	}
	public void setParent(long parent) {
		this.parent = parent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrdering() {
		return ordering;
	}
	public void setOrdering(String ordering) {
		this.ordering = ordering;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public int getAllow_comments() {
		return allow_comments;
	}
	public void setAllow_comments(int allow_comments) {
		this.allow_comments = allow_comments;
	}
	public int getAllow_ads() {
		return allow_ads;
	}
	public void setAllow_ads(int allow_ads) {
		this.allow_ads = allow_ads;
	}
}

