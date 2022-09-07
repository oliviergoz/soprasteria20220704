package formation.sopra.formationSpringBoot.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		
		http.antMatcher("/api/**")
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
					.antMatchers("/api/auth/inscription").permitAll()
					.antMatchers("/api/produit/**").permitAll()
					.antMatchers("/api/fournisseur/**").permitAll()
					.antMatchers("/api/**").authenticated()
				.and()
				.httpBasic();
//		.and()
				
		
//		http
//			.antMatcher("/**")
//				.csrf().disable()
//				.authorizeHttpRequests()
//					.antMatchers("/login").permitAll()
//					.antMatchers(HttpMethod.GET,"/produit/**").permitAll()
//					.antMatchers("/fournisseur/**").hasAnyRole("ADMIN")
//					.anyRequest().authenticated()
//					.and()
//					.formLogin()
//						.loginPage("/login") //controller qui gere l'url
//						.defaultSuccessUrl("/secure/home") //controller
//						.failureUrl("/login?error=")
//					.and()
//					.logout()
//						.logoutUrl("/logout")
//						.logoutSuccessUrl("/produit");
//					.anyRequest().permitAll();
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
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
