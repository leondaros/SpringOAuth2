package com.backend.projeto.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.backend.projeto.entity.Role;
import com.backend.projeto.entity.User;
import com.backend.projeto.repository.RoleRepository;
import com.backend.projeto.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<User> users = userRepository.findAll();
		if(users.isEmpty()){
			this.createUsers("Leon","leondaros@gmail.com",passwordEncoder.encode("123456"),"ROLE ALUNO");
			this.createUsers("Leon Daros","admin",passwordEncoder.encode("123456"),"ROLE ADMIN");

		}
	}
	
	public void createUsers(String name,String email,String password,String role){
		Role roleObject = new Role();
		roleObject.setName(role);
		this.roleRepository.save(roleObject);
		User user = new User(name,email,password,Arrays.asList(roleObject));
		userRepository.save(user);
	}

}
