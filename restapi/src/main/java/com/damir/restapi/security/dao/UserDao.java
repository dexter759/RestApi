package com.damir.restapi.security.dao;

import com.damir.restapi.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<ApplicationUser, Long>{

    ApplicationUser findByUsername(String username);

}
