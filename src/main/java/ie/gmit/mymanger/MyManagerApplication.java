/**
 * Web application for invoice management.
 * 
 * @author Alexander Souza - G00317835
 * @version 1.0
 * @since   15/01/2017
 */

package ie.gmit.mymanger;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class MyManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyManagerApplication.class, args);
	}

	/**
	 * Solve differents format number for differents country
	 *
	 * @return Will Return Portuguese Brazil
	 * 
	 */
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

	/**
	 * The Class MvcConfig, Enables you to add all additional settings in the
	 * system.
	 */
	@Configuration
	public static class MvcConfig extends WebMvcConfigurerAdapter {

		/*
		 * After login the page, the first page to shown is /invoices
		 * 
		 * @see org.springframework.web.servlet.config.annotation.
		 * WebMvcConfigurerAdapter#addViewControllers(org.springframework.web.
		 * servlet.config.annotation.ViewControllerRegistry)
		 */
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/invoices");
		}

	}

}
