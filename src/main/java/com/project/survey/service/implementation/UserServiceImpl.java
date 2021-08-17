package com.project.survey.service.implementation;

import com.project.survey.model.User;
import com.project.survey.model.UserRole;
import com.project.survey.repo.RoleRepo;
import com.project.survey.repo.UserRepo;
import com.project.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    //creating user
    @Override
    public User addUser(User user, Set<UserRole> userRoles) throws Exception {
        com.project.survey.model.User local = this.userRepo.findByUsername(user.getUsername());
        if(local!=null)
        {
            System.out.println("User already present");
            throw new Exception("User already present");
        }
        else
        {
            for(UserRole ur:userRoles)
            {
                roleRepo.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepo.save(user);

        }
        return local;
    }

    //user by username
    @Override
    public User getUser(String username) {
        return this.userRepo.findByUsername(username);
    }

//    @Override
//    public User addUser(User user, Set<UserRole> userRoles) throws Exception {
//
//        com.project.survey.model.User local = this.userRepo.findByUsername(user.getUsername());
//        if(local!=null)
//        {
//            System.out.println("User already present");
//            throw new Exception("User already present");
//        }
//        else
//        {
//            for(UserRole ur:userRoles)
//            {
//                roleRepo.save(ur.getRole());
//            }
//
//            user.getUserRoles().addAll(userRoles);
//            local = this.userRepo.save(user);
//
//        }
//        return local;
//    }

}
