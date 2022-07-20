package formationSpring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonAspect {

	@Pointcut("execution(* formationSpring.beans.Presentation.sePresenter())")
	public void pointcutSePresenter() {

	}

	// @Before("execution(* formationSpring.beans.Presentation.sePresenter())")
	@Before("pointcutSePresenter()")
	public void methodeBefore() {
		System.out.println("methode executee avant la methode sePresenter");
	}

	@After("pointcutSePresenter()")
	public void methodeAfter() {
		System.out.println("methode executee apres la methode sePresenter");
	}

	@AfterReturning(pointcut = "pointcutSePresenter()", returning = "retour")
	public void methodeAfterReturning(String retour) {
		System.out.println("methde executee apres le return de la methode sePresenter");
		System.out.println("valeur renvoyee:" + retour);
	}

	@AfterThrowing(pointcut = "pointcutSePresenter()")
	public void methodeAfterThrowing() {
		System.out.println("un probleme pendant l'execution");
	}

	@Around("pointcutSePresenter()")
	public String around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("avant l'execution de la methode");
		String retour = (String) proceedingJoinPoint.proceed();
		System.out.println("apres l'execution de la methode");
		return retour;
	}
}
