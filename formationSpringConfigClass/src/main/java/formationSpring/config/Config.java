package formationSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import formationSpring.beans.Adresse;

@Configuration
@ComponentScan(basePackages = {"formationSpring.beans","formationSpring.aspects"})
@EnableAspectJAutoProxy
public class Config {

	@Bean("paris")
	public Adresse paris() {
		Adresse paris=new Adresse();
		paris.setAdresse("une adresdddddse à paris");
		return paris;
	}
	
	@Bean("lille")
	public Adresse lille() {
		Adresse paris=new Adresse();
		paris.setAdresse("une adresdddddse à lille");
		return paris;
	}
}
