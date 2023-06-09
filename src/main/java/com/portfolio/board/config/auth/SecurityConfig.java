package com.portfolio.board.config.auth;

import com.portfolio.board.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                // 권한 설정
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**","/api/v2/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                // 로그아웃 설정
                .logout()
                .logoutSuccessUrl("/")
                .and()
                // OAuth2 로그인 설정
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}