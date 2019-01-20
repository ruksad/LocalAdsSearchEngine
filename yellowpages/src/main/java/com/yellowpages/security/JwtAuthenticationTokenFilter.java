package com.yellowpages.security;

import com.yellowpages.security.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ruksad siddiqui on 7/4/18
 */
@Slf4j
@AllArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    private CustomUserDetailsService customUserDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private String tokenHeader;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authToken = request.getHeader(this.tokenHeader);
        // authToken.startsWith("Bearer ")
        // String authToken = header.substring(7);

        if(authToken != null && authToken.startsWith("Bearer")) {
            authToken = authToken.substring(7);
        }

        String userName = jwtTokenUtil.getUsernameFromToken(authToken);

        log.info("checking authentication für user: {} ",userName);

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // It is not compelling necessary to load the use details from the database. You could also store the information
            // in the token and read it from it.
            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(userName);

            if (jwtTokenUtil.validateToken(authToken, userDetails)){
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                log.info("authenticated user: {} and setting security context" , userName );
                 SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request,response);
    }
}
