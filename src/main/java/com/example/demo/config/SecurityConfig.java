package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
  private   DataSource dataSource;


    @Value("${COOKIE.VALIDITY}")
    private Integer COOKIE_VALIDITY;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/**","/templates/**","/login/**","/static/**",
                        "/asserts/**","/asserts/css","/static/asserts/img","/asserts/js").permitAll()
                .anyRequest().authenticated();


        //开启自动配置的登陆功能，效果，如果没有登陆，没有权限就会来到登陆页面
        http.formLogin().loginPage("/login").permitAll()
                .usernameParameter("username").passwordParameter("password")

                .defaultSuccessUrl("/")
        .failureUrl("/login?error")
               ;

        // 3、设置用户登录后cookie有效期，默认值30分钟
        http.rememberMe().alwaysRemember(true).tokenValiditySeconds(COOKIE_VALIDITY);

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");//注销成功以后来到首页

        //开启记住我功能
        http.rememberMe().rememberMeParameter("remeber");


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //  密码需要设置编码器
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //  使用JDBC进行身份认证
        String userSQL ="select username,password,valid from t_user where username = ?";

        String authoritySQL ="select u.username,a.authority from t_user u,t_authority a," +
                "t_user_authority ua where ua.user_id=u.id " +
                "and ua.authority_id=a.id and u.username =?";
        auth.jdbcAuthentication().passwordEncoder(encoder)
                .dataSource(dataSource)
                .usersByUsernameQuery(userSQL)
                .authoritiesByUsernameQuery(authoritySQL);
    }


}
