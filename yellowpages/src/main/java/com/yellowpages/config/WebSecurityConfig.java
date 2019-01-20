package com.yellowpages.config;

import com.yellowpages.security.JwtAuthenticationEntryPoint;
import com.yellowpages.security.JwtAuthenticationTokenFilter;
import com.yellowpages.security.JwtTokenUtil;
import com.yellowpages.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Ruksad siddiqui on 6/4/18
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.route.authentication.path}")
    private String authenticationPath;

    @Value("${jwt.route.authentication.pathignore}")
    private String authenticationIgnorePath;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(this.customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }


    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring().antMatchers(HttpMethod.POST,authenticationPath)
                .and()
                .ignoring()
                .antMatchers(authenticationIgnorePath)
                .and()
                .ignoring()
                .antMatchers(HttpMethod.OPTIONS)
                .and()
                .ignoring()
                .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
                        "/swagger-ui.html", "/webjars/**", "/swagger-resources/configuration/ui", "/swagger-ui.html",
                        "/swagger-resources/configuration/security")
                // allow anonymous resource requests
                .and()
                .ignoring()
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/**/*.eot",
                        "/**/*.woff2",
                        "/**/*.ttf",
                        "/**/*.woff",
                        "/**/*.json",
                        "/**/*.svg",
                        "/**/*.png",
                        "/**/*.jpg"

                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .anyRequest().authenticated();

        JwtAuthenticationTokenFilter authenticationTokenFilter = new JwtAuthenticationTokenFilter(customUserDetailsService, jwtTokenUtil, tokenHeader);
        // Custom JWT based security filter
        http
                .addFilterBefore(authenticationTokenFilter,UsernamePasswordAuthenticationFilter.class);

        // disable page caching
        http
                .headers().cacheControl();
    }
}
