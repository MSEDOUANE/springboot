package com.example.springboot.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

import javax.persistence.*;


@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Table(name = "users")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
	private int id;
    @Column(nullable = false, unique = true)
	private String name;
	@NonNull
	private String password;
	@NonNull
	private String email;
	@NonNull
	private String full_name;
	@NonNull
	private int group_id;
	@NonNull
	private int trust_status;
	@NonNull
	private int register_status;
	@NonNull
	private Date date;
	@NonNull
	private String avatar;
	public User(String name, String password,String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public int getTrust_status() {
		return trust_status;
	}
	public void setTrust_status(int trust_status) {
		this.trust_status = trust_status;
	}
	public int getRegister_status() {
		return register_status;
	}
	public void setRegister_status(int register_status) {
		this.register_status = register_status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	

}

