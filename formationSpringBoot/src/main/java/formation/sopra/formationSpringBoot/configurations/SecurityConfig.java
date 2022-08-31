package formation.sopra.formationSpringBoot.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.antMatcher("/**")
				.authorizeHttpRequests()
					.antMatchers(HttpMethod.GET,"/produit/**").permitAll()
					.antMatchers("/fournisseur/**").hasAnyRole("ADMIN")
					.anyRequest().authenticated()
					.and()
					.formLogin();
					//.anyRequest().permitAll();
		// @formatter:on

	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//utilisateur en memoire
		// @formatter:off
//		auth.inMemoryAuthentication()
//				.withUser("admin").password("{noop}admin").roles("ADMIN","USER")
//				.and()
//				.withUser("user1").password("{noop}user1").roles("USER");
		// @formatter:on
		
		auth.userDetailsService(userDetailsService);

		
	}
}
