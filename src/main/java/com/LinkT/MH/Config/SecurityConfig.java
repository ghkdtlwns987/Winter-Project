package com.LinkT.MH.Config;

import com.LinkT.MH.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpSession;

@EnableWebSecurity        //spring security 를 적용한다는 Annotation
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    /**
     * 규칙 설정
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers( "/LoginForm,do", "/JoinForm.do", "/access_denied", "/resources/**").permitAll() // 로그인 권한은 누구나, resources파일도 모든권한
                // USER, ADMIN 접근 허용
                .antMatchers("/userAccess").hasRole("USER")
                .antMatchers("/userAccess").hasRole("ADMIN")
                .and()
            .formLogin()
                .loginPage("/LoginForm.do")
                .loginProcessingUrl("/login_proc")
                .defaultSuccessUrl("/User_Access")
                .usernameParameter("id")
                .passwordParameter("pw")
                .failureUrl("/Access_Denined") // 인증에 실패했을 때 보여주는 화면 url, 로그인 form으로 파라미터값 error=true로 보낸다.
                .permitAll()
                .and()
            .csrf().disable();		//로그인 창
        // 여기서부터 로그아웃 API 내용~!
        http.logout()
                .logoutUrl("/Logout.do")   // 로그아웃 처리 URL (= form action url)
                //.logoutSuccessUrl("/login") // 로그아웃 성공 후 targetUrl,
                // logoutSuccessHandler 가 있다면 효과 없으므로 주석처리.
                .addLogoutHandler((request, response, authentication) -> {
                    // 사실 굳이 내가 세션 무효화하지 않아도 됨.
                    // LogoutFilter가 내부적으로 해줌.
                    HttpSession session = request.getSession();
                    if (session != null) {
                        session.invalidate();
                    }
                })  // 로그아웃 핸들러 추가
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.sendRedirect("/LoginForm.do");
                }) // 로그아웃 성공 핸들러
                .deleteCookies("remember-me"); // 로그아웃 후 삭제할 쿠키 지정
    }

    /**
     * 로그인 인증 처리 메소드
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
}