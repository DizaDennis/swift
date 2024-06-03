package com.sales.swift.service;


import com.sales.swift.entities.User;
import com.sales.swift.repositories.UserRepository;
import com.sales.swift.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
 * Objective of this class is security related.
 * It performs authentication, using the data in the DB
 * Implementing UserDetailsService allows us to find a user based on the username
 * This class (services) needs to interact with a repo to perform it's task
 * @author dennisdiza
 */


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    /*
    loadByUsername method accesses the DB to look for a username that matches the username passed in
    If it finds one, it then checks to see if the passwords match
    */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("Invalid login credentials");
        }

        return new CustomSecurityUser(user);
    }
}
