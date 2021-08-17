package com.project.survey.controller;
import com.project.survey.model.Role;
import com.project.survey.model.User;
import com.project.survey.model.UserRole;
import com.project.survey.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles =  new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return userService.addUser(user, roles);
    }

        @GetMapping("/{username}")
        public User getUser(@PathVariable("username") String username){
            return this.userService.getUser(username);
        }
//    @GetMapping("/allUsers")
//    public ResponseEntity<List<User>> findAllUsers(){
//        List<User> users = userService.allUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @GetMapping("/userById/{id}")
//    public User findUserById(@PathVariable int id) {
//        return userService.getUserById(id);
//    }

}