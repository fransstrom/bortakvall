package com.example.bortakvall.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .permitAll()
                    .defaultSuccessUrl("/home")
                    .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .permitAll()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers( "/css/**").permitAll()
                    .anyRequest().authenticated();
        }

        @Bean
        protected UserDetailsService userDetails() {
            User.UserBuilder builder =
                    User.withDefaultPasswordEncoder();
            InMemoryUserDetailsManager manager =
                    new InMemoryUserDetailsManager();
            manager.createUser(
                    builder
                            .username("user")
                            .password("password")
                            .roles("USER")
                            .build());
            manager.createUser(
                    builder
                            .username("admin")
                            .password("password")
                            .roles("USER", "ADMIN")
                            .build());
            return manager;

    }

































    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/css/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("pass").roles("USER");

    }*/
}
