package demoSpring.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import demoSpring.Guitariste;
import demoSpring.Musicien;

@Component
@Aspect
public class Spectateur {

	@Autowired
	@Qualifier("guitariste")
	private Musicien guitariste;

	public Spectateur() {
		System.out.println("creation bean spectateru");
	}

	@Before("execution(String demoSpring.Pianiste.perform())")
	public void arrivee() {
		System.out.println("les spectateurs coupent leur portable");
	}

	@After("execution(String demoSpring.Guitariste.perform())")
	public void depart() {
		System.out.println("les spectateurs partent");
	}

	@AfterReturning(pointcut = "execution(String demoSpring.Musicien.perform())")
	public void bravo() {
		System.out.println("bravo");
	}

	@AfterThrowing(pointcut = "execution(String demoSpring.Musicien.perform())")
	public void huer() {
		System.out.println("bouhhhh");
	}

	@After("execution(String demoSpring.Pianiste.perform())")
	public void suivant() {
		guitariste.perform();
	}
}
