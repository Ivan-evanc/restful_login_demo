package com.me2cell.login.com.LoginService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages= {"controller","service","repository","com.me2cell.login.com.LoginService"})
@EnableJpaRepositories("repository")
@EntityScan("model")
@ComponentScan(basePackages = {"controller","repository","service","model","com.me2cell.login.com.LoginService" })
@PropertySources(value= {@PropertySource("classpath:application.properties")})
public class LoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}
	
	@Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
	  return new BCryptPasswordEncoder();
	 }
}
