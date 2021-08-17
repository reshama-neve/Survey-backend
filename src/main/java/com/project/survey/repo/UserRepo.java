package com.project.survey.repo;

import com.project.survey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query("select u from User where u.email = : email")
    User findByUsername(@Param("email") String email);
}
