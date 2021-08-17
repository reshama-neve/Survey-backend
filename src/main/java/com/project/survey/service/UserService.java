package com.project.survey.service;

import com.project.survey.model.User;
import com.project.survey.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    public User addUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);
}
