package ie.gmit.mymanger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
	protected void configure(HttpSecurity http) throws Exception {
		  http
		    .authorizeRequests()
		        .antMatchers("/js/**", "/css/**").permitAll()
		        .antMatchers("/customers/newcustomer").hasRole("ADMIN")
		        .antMatchers("/customers").hasRole("USER")
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
        auth.inMemoryAuthentication().withUser("admin").password("123").roles("USER", "ADMIN");

    }

}
