package formation.sopra.authExercice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/**")
				.csrf().disable()
				.authorizeRequests()
					.antMatchers("/","/home").permitAll()
					.antMatchers("/inscription","/login").anonymous()
					.anyRequest().authenticated()
					.and()
					.formLogin()
						.loginPage("/login")
						.defaultSuccessUrl("/secure/home")
						.failureUrl("/login?error=")
					.and()
					.logout()
						.logoutUrl("/logout")
						.logoutSuccessUrl("/home");
		return http.build();
		// @formatter:on
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
