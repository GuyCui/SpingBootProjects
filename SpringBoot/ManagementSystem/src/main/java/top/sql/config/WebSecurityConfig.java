package top.sql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import top.sql.service.sysUser.SysSecurityService;

import javax.annotation.Resource;

/**
 * 指定为Spring Security配置类
 * 启用方法安全设置
 * {@code @Author:} CMZ
 * {@code @DateTime:} 2022/12/1 19:59
 * {@code @Description:} ManagementSystem TODO
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Resource
    private AuthenticationFailureHandler myAuthenticationFailHandler;
    
    @Bean
    /**
     * 使用 BCrypt 加密
     */ public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    UserDetailsService Service() {
        return new SysSecurityService();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(Service()).passwordEncoder(new BCryptPasswordEncoder() {
        });
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/admin/**").
                //指定登录认证的Controller
                        formLogin().usernameParameter("uname").passwordParameter("pwd").loginPage("/admin/login").successHandler(myAuthenticationSuccessHandler).failureHandler(myAuthenticationFailHandler).and().authorizeRequests()
                //登录相关
                .antMatchers("/admin/login", "/admin/role", "/admin/user").permitAll()
                //rabc相关
                // .antMatchers("/admin/rbac").access("@rbacService.hasPermission(request,authentication)")
                //.antMatchers("/admin/**").access("hasRole('ADMIN') or @rbacService.hasPermission(request,authentication)")
                .antMatchers("/redis/**").permitAll()
        // .anyRequest().access("@rbacService.hasPermission(request,authentication)")
        ;
        http.logout().logoutUrl("/admin/logout").permitAll();
        //记住我功能
        http.rememberMe().rememberMeParameter("rememberme");
        http.csrf().ignoringAntMatchers("/admin/upload");
        //解决X-Frame-Options deny 造成的页面空白,不然后台不能用frame
        http.headers().frameOptions().sameOrigin();
    }
}