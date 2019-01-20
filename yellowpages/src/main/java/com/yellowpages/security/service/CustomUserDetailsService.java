package com.yellowpages.security.service;

import com.yellowpages.model.ObjectEntity;
import com.yellowpages.repository.ObjectEntityRepository;
import com.yellowpages.security.model.JwtUser;
import com.yellowpages.security.model.User;
import com.yellowpages.security.model.factory.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Ruksad siddiqui on 6/4/18
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ObjectEntityRepository objectEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<ObjectEntity> objectEntity = this.objectEntityRepository.findByNameIgnoreCase(userName.trim());
        if(Objects.isNull(objectEntity) || objectEntity.isEmpty())
            throw new UsernameNotFoundException("User is not found in object entities");

        JwtUser jwtUser = JwtUserFactory.create(objectEntity.get(0));


        return jwtUser;
    }
}
