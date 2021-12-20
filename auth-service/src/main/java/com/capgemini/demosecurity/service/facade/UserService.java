package com.capgemini.demosecurity.service.facade;

import com.capgemini.demosecurity.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

    User save(User user);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
