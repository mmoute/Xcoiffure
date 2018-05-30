package fr.Xcoiffure.principal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication
{
	public static void run(Class<?> config, String[] args) {
		AnnotationConfigApplicationContext myContext =
				new AnnotationConfigApplicationContext(config);
		try {
		myContext.getBeanFactory().createBean(AppConsole.class).run(args);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		myContext.close();
	}
}