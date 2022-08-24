package eshop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eshop.config.AppConfig;

/**
 * Application Lifecycle Listener implementation class
 * CustomServletContextListener
 *
 */
@WebListener
public class CustomServletContextListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public CustomServletContextListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		((AnnotationConfigApplicationContext) sce.getServletContext().getAttribute("spring")).close();
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("spring", new AnnotationConfigApplicationContext(AppConfig.class));
	}

}
