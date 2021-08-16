package com.project.survey.service;

import com.project.survey.model.User;
import com.project.survey.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =this.userRepo.findByUsername(username);
        if(user==null)
        {
            System.out.println("User not Found");
            throw new UsernameNotFoundException("No user found !!");
        }


        return user;
    }
}
