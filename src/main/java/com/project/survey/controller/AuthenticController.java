package com.project.survey.controller;

import com.project.survey.config.JwtUtils;
import com.project.survey.model.JwtRequest;
import com.project.survey.model.JwtResponse;
import com.project.survey.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthenticController {

    @Autowired
    private AuthenticationManager authenticationManager;

   @Autowired
    private UserDetailService userDetailService;

   @Autowired
   private JwtUtils jwtUtil;



   //generate token
    @PostMapping("/generate-token")
    public ResponseEntity<?>generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{

            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());

        }catch(UsernameNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("User not found");
        }
        /////authenticate
        UserDetails userDetails =this.userDetailService.loadUserByUsername(jwtRequest.getUsername());
       String token=this.jwtUtil.generateToken(userDetails);
       return ResponseEntity.ok(new JwtResponse(token));
    }


     private void authenticate(String username,String password) throws Exception {
            try
            {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

            }catch(DisabledException e)
            {
                throw new Exception("User Disabled"+e.getMessage());
            }catch (BadCredentialsException e)
            {

                throw new Exception("Invalid Credentials"+e.getMessage());
            }
    }
}
