package com.project.survey;

import com.project.survey.model.Role;
import com.project.survey.model.User;
import com.project.survey.model.UserRole;
import com.project.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SurveyApplication implements CommandLineRunner {

	@Autowired
	private final UserService userService;

	public SurveyApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting Code");

//		User user = new User();
//
//		user.setFirst_name("Admin");
//		user.setLast_name("Control");
//		user.setUsername("admin@gmail.com");
//		user.setPassword("Admin123");
//
//		Role role = new Role();
//		role.setRoleId(44L);
//		role.setRoleName("ADMIN");
//
//		Set<UserRole> userRoles = new HashSet<>();
//		UserRole userRole = new UserRole();
//
//		userRole.setRole(role);
//		userRole.setUser(user);
//
//		userRoles.add(userRole);
//
//		User admin = this.userService.addUser(user, userRoles);
//		System.out.println(admin.getUsername());

	}
}
