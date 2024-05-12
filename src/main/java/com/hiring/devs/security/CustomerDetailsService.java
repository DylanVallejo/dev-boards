package com.hiring.devs.security;

import com.hiring.devs.entity.Developer;
import com.hiring.devs.repository.DeveloperRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
@Slf4j
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private DeveloperRepository developerRepository;

    private Developer devDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("buscando usuario {}", username);
        devDetails = developerRepository.findByEmail(username);
        if (!Objects.isNull(devDetails)){
            return new org.springframework.security.core.userdetails.User(devDetails.getEmail(), devDetails.getPassword(), new ArrayList<>() );
        }else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    public Developer getDevDetails(){return devDetails;}

}
