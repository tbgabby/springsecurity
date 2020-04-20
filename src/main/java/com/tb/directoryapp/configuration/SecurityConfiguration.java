package com.tb.directoryapp.configuration;


import com.tb.directoryapp.services.TravelbetadminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import java.security.SecureRandom;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private TravelbetadminService travelbetadminService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(
                    "/registration",
                    "/adminstrator/user",
                    "/adminstrator/users",
                    "/adminstrator/view",
                    "/adminstrator/update",
                    "/adminstrator",
                    "/interactions",
                    "/registration**",
                    "/adminstrator**",
                    "/",
                    "/js**",
                    "/css**",
                    "/fonts**",
                    "/images**",
                    "/assets**",
                    "/main**",
                    "/webjars**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/auth/login")
            .permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/auth/login?logout")
            .permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        String SALT = "salt";   // Cryptographically Secure Pseudo-Random Number Generator (CSPRNG)
        return new BCryptPasswordEncoder(8, new SecureRandom(SALT.getBytes()));
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(travelbetadminService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        SecureRandom random = new SecureRandom();
//        byte[] bytes = new byte[20];
//        random.nextBytes(bytes);
//        return new BCryptPasswordEncoder(10, random);
//    }