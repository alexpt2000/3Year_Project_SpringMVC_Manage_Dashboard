package ie.gmit.mymanger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class InMemorySecurityConfig {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
		.inMemoryAuthentication()
		.withUser("alex").password("123").roles("USER")
		.and()
		.withUser("gmit").password("123").roles("USER")
		.and().
		withUser("user").password("123").roles("USER");
	}
}
