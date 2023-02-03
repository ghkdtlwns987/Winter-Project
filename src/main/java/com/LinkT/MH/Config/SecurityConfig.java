package com.LinkT.MH.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity // WebSecurityConfigureAdapter를 상속받는 클래스에 해당 Annotation을 선언하면 SpringSecurityFilterChaing이 자동으로 포함됨.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {      // http 요청에 대한 보안 설정

    }

    @Bean
    public PasswordEncoder passwordEncoder() {      // 비밀번호를 암호화하는 함수
        return new BCryptPasswordEncoder();
    }
}