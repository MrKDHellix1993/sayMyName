/*
 * package io.javaworkshop.coronavirustracker.config.security;
 * 
 * import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * @EnableWebSecurity public class SecurityConfiger extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable().authorizeRequests().antMatchers("/api/auth/**").
 * permitAll().anyRequest().authenticated(); }
 * 
 * }
 */