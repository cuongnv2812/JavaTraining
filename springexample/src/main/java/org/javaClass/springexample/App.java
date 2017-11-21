package org.javaClass.springexample;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	private final static Logger LOGGER = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	//JavaClazz clazz = (JavaClazz) context.getBean("jee01");
    	HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
    	obj.sayHello();
    	/*LOGGER.info("Map Implement is " + clazz.getStudents().getClass());
    	LOGGER.info("There are" + clazz.getStudents().size() + " in the class");*/
    	HelloClazz clazz=  (HelloClazz) context.getBean("helloJavaClazz");
    	LOGGER.info("Total class is " + clazz.getClazzes().size());
    	
    	
    }
}
