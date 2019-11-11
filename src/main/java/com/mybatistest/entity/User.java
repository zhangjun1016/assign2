package com.mybatistest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Configuration
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@NotBlank(message = "email is mandatory")
	private String email;
	
	private String projectname;
	
	@Value("${process.mavenProcess}")
	private String mavenProcess;
	
	private String databaseProcess;
	
	
	private String assign1;
	
	private String assign2;
	
	private String assign3;
	
	private String assign4;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getMavenProcess() {
		return mavenProcess;
	}

	
	public void setMavenProcess(String mavenProcess) {
		this.mavenProcess = mavenProcess;
	}

	public String getDatabaseProcess() {
		return databaseProcess;
	}

	public void setDatabaseProcess(String databaseProcess) {
		this.databaseProcess = databaseProcess;
	}

	public String getAssign1() {
		return assign1;
	}

	public void setAssign1(String assign1) {
		this.assign1 = assign1;
	}

	public String getAssign2() {
		return assign2;
	}

	public void setAssign2(String assign2) {
		this.assign2 = assign2;
	}

	public String getAssign3() {
		return assign3;
	}

	public void setAssign3(String assign3) {
		this.assign3 = assign3;
	}
	
	public String getAssign4() {
		return assign4;
	}

	public void setAssign4(String assign3) {
		this.assign4 = assign3;
	}
	
	
	

}
