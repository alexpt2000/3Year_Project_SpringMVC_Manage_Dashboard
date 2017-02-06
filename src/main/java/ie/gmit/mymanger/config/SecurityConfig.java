package ie.gmit.mymanger.config;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
	protected void configure(HttpSecurity http) throws Exception {
		  http
		    .authorizeRequests()
		        .antMatchers("/js/**", "/css/**").permitAll()
		        .antMatchers("/invoices/**").hasRole("USER")
		    .and()
		    .formLogin()
		        .loginPage("/login").permitAll()
		        .and()
		        .rememberMe();
		}

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("alex").password("123").roles("USER");

    }
	


}
