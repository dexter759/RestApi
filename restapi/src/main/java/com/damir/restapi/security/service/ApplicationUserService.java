package com.damir.restapi.security.service;

import com.damir.restapi.entity.ApplicationUser;
import com.damir.restapi.security.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static java.util.Collections.emptyList;

public class ApplicationUserService implements UserDetailsService{

    @Autowired
    private UserDao userDao;


   public void save(ApplicationUser user){
       userDao.save(user);
   }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       ApplicationUser user = userDao.findByUsername(s);
       if(user == null){
           throw new UsernameNotFoundException(s);
       }
        return new User(user.getUsername(), user.getPassword(), emptyList());
    }
}
