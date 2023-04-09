package com.abdullah.notesApp.util;

import com.abdullah.notesApp.entity.User;
import com.abdullah.notesApp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotesAppAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        List<User> users = repository.findByUsername(username);

        if (users.size() > 0) {
            User user = users.get(0);
            if (passwordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(username, pwd, new ArrayList<>());
            } else {
                System.out.println("Request Not Authorised - in authenticate function");
            }
        }
        throw new UsernameNotFoundException("User not found");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
