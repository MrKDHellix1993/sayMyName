/*
 * package io.javaworkshop.coronavirustracker.config.security;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.NoOpPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * io.javaworkshop.coronavirustracker.controllers.HomeDataRestController; import
 * io.javaworkshop.coronavirustracker.services.MyUserDetailsService;
 * 
 * @EnableWebSecurity public class SecurityConfiger extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired private MyUserDetailsService userDetailsService;
 * 
 * 
 * //InMemoryAuthentication
 * 
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throw
 * Exception {
 * auth.inMemoryAuthentication().withUser("user").password("password").roles(
 * "USER"); }
 * 
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.userDetailsService(userDetailsService); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return
 * NoOpPasswordEncoder.getInstance(); }
 * 
 * 
 * // Role Based Security Configrtn
 * 
 * @Override public void configure(HttpSecurity http) throws Exception {
 * http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers(
 * "/user").hasAnyRole("ADMIN", "USER")
 * .antMatchers("/home").hasRole("USER").and().formLogin(); }
 * 
 * 
 * 
 * }
 */