package demoSpring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import demoSpring.Instrument;
import demoSpring.Musicien;
import demoSpring.Pianiste;

@Configuration
@ComponentScan(basePackages = { "demoSpring", "demoSpring.aspects" })
@EnableAspectJAutoProxy
public class Config {

	@Bean("toto")
	public Musicien pianiste(@Qualifier("piano") Instrument instrument) {
		Pianiste pianiste = new Pianiste();
		pianiste.setInstrument(instrument);
		return pianiste;
	}
}
