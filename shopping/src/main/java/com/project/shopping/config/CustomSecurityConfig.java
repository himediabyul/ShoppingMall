package com.project.shopping.config;


import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Log4j2
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeHttpRequests()
//                .antMatchers( "/sell/list","/sell/read","/join/**").hasRole("USER")
//                .antMatchers("/sell/**", "/join/**").hasRole("ADMIN")
                .anyRequest().permitAll();


        // form 로그인 페이지에 대한 설정 , 성공시 처리 핸들러 등록
        http.formLogin().defaultSuccessUrl("/");
        // /auth/login 요청의 페이지는 사용자가 직접 만든 페이지


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
