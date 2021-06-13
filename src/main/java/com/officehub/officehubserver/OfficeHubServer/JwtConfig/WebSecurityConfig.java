package com.officehub.officehubserver.OfficeHubServer.JwtConfig;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.officehub.officehubserver.Authentication.JwtAuthTokenProvider;
import com.officehub.officehubserver.Authentication.Role;
import com.officehub.officehubserver.OfficeHubServer.exception.JwtAccessDeniedHandler;
import com.officehub.officehubserver.OfficeHubServer.exception.JwtAuthenticationEntryPoint;
import com.officehub.officehubserver.SpringSecurity.JwtConfigurer;
import com.officehub.officehubserver.SpringSecurity.JwtFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final JwtAuthenticationEntryPoint authenticationErrorHandler;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()

                .exceptionHandling()
                .authenticationEntryPoint(authenticationErrorHandler)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()

                .antMatchers("/login/**").hasAnyAuthority(Role.USER.getCode())
                .anyRequest().authenticated()

                .and()
                .apply(securityConfigurerAdapter());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")

                // allow anonymous resource requests
                .antMatchers(
                        "/",
                        "/h2-console/**"
                );
    }

    private JwtConfigurer securityConfigurerAdapter() {
        return new JwtConfigurer(jwtAuthTokenProvider);
    }
}
