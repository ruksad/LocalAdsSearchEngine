package com.yellowpages.security.model.factory;

import com.yellowpages.model.ObjectEntity;
import com.yellowpages.security.model.JwtUser;
import com.yellowpages.security.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ruksad siddiqui on 7/4/18
 */
public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(ObjectEntity objectEntity) {
        User user = User.from(objectEntity);
        Date lastPasswordReset = new Date(1523085196L);
        return new JwtUser( user.getUserId(), user.getUserName(), "Test firstname","Test LastName",user.getEmail(), user.getPassword(),
                mapToGrantedAuthorities(Arrays.asList(user.getRole())),true, lastPasswordReset,user.getRegisteredSince(),user.getRegisteredUserStatus()
        ,user.getTelephone());
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
    }
}
