package com.project.shopping.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomSecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeHttpRequests()
//                .antMatchers( "/sell/**","/member/**").hasRole("USER")
//                .antMatchers("/sell/**","/member/**").hasRole("ADMIN")
                .anyRequest().permitAll();


        // form 로그인 페이지에 대한 설정
        http.formLogin()
                .loginPage("/member/login")
                .defaultSuccessUrl("/");
//                .failureUrl("/member/login/error");


        // 로그아웃
        http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");
        // /auth/logout => Security 가 자동 매핑

        // 자동 로그인
        http.rememberMe()
                .key("123456789")
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(60*60*24*7);

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

}
