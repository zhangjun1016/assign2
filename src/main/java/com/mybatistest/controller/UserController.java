package com.mybatistest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.mybatistest.model.*;

import com.mybatistest.entity.User;
import com.mybatistest.repository.UserRepository;



@Controller
public class UserController {
	
	@Autowired UserRepository userRepository;
	
	@GetMapping("/")
	public String showAllUsers(Model model) {
		model.addAttribute("users",userRepository.findAll());
		return "index";
	}
	
	@GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }
	
	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result, ErrorInfo errorInfo, Model model) {
		if (result.hasErrors()) {
			errorInfo.setErrorCount(result.getErrorCount());
			errorInfo.setErrorCode(result.getFieldError().getCode());
			errorInfo.setErrorMessage(result.getFieldError().getDefaultMessage());
			errorInfo.setErrorField(result.getFieldError().getField());
			errorInfo.setErrorObjectName(result.getFieldError().getObjectName());
			
			errorInfo.setErrorDescription("error occurred in adduser part");
			model.addAttribute("errorinfo", errorInfo);
			return "error-shown";
		}
		
		userRepository.save(user);
		model.addAttribute("users",userRepository.findAll());
		return "index";
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("invalid user id:" + id));
		
		model.addAttribute("user", user);
		return "update-user";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, ErrorInfo errorInfo, Model model) {
		if (result.hasErrors()) {
			errorInfo.setErrorCount(result.getErrorCount());
			errorInfo.setErrorDescription("error occurred in update, the user id is: "+id);
			
			errorInfo.setErrorCode(result.getFieldError().getCode());
			errorInfo.setErrorMessage(result.getFieldError().getDefaultMessage());
			errorInfo.setErrorField(result.getFieldError().getField());
			errorInfo.setErrorObjectName(result.getFieldError().getObjectName());
			model.addAttribute("errorinfo", errorInfo);
			//user.setId(id);
			return "error-shown";
		}
		
		userRepository.save(user);
		model.addAttribute("users",userRepository.findAll());
		return "index";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("invalid user id:" + id));
		userRepository.delete(user);
		model.addAttribute("users",userRepository.findAll());
		return "index";
	}
	

}
