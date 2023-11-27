package com.ep.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ep.backend.entities.Student;


@Configuration
public class SecurityConfig {
	
	 @Autowired
	    private UserDetailsService userDetailsService;
	
//	to configue user 
//	@Bean
//	public UserDetailsService userDetailsService() {
//		   UserDetails normal = User.builder()
//	                .username("Ankit")
//	                .password(passwordEncoder().encode("ankit"))
//	                .roles("NORMAL")
//	                .build();
//	
//	        UserDetails admin = User.builder()
//	                .username("Durgesh")
//	                .password(passwordEncoder().encode("durgesh"))
//	                .roles("ADMIN")
//	                .build();
////	    users create
////	    InMemoryUserDetailsManager- is implementation class of UserDetailService
//	        return new InMemoryUserDetailsManager(normal, admin);	
//		
		
		
		
//	}
	 
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


	
//	        http.authorizeRequests()
//	                .anyRequest()
//	                .authenticated()
//	                .and().
//	                formLogin()
//	                .loginPage("login.html")
//	                .loginProcessingUrl("/process-url")
//	                .defaultSuccessUrl("/dashboard")
//	                .failureUrl("/error")
//	                .and()
//	                .logout()
//	                .logoutUrl("/do-logout");


         http.
	            csrf()
                 .disable()
                 .cors()
                 .disable()
                 .authorizeRequests()
                 .anyRequest()
                 .authenticated()
                 .and()
                 .httpBasic();
                 
                 
                 
return http.build();
	    }

	
//	 to load details from database
	
	 @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	        daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);
	        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	        return daoAuthenticationProvider;

	 }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
