package edu.java.spring.springJdbc;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	final Logger LOGGER = Logger.getLogger(App.class);
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	StudentJdbcDAO jdbc= (StudentJdbcDAO) context.getBean("studentJdbcDAO");
    	LOGGER.info("create Bean" + jdbc);
    //	jdbc.insert("Nguyen Van C", 25);
    	LOGGER.info("Total student is: " + jdbc.totalRecord());
    	
    	jdbc.updateAgeByName(30,"Nguyen Van B");
    	jdbc.loadStudent("B").forEach(student->LOGGER.info(student));
    	List<Student> listStudent = new ArrayList<Student>();
    	listStudent.add(new Student("Tran thi A",17));
    	listStudent.add(new Student("Nguyen Hoang T",28));
    	int[] values=jdbc.add(listStudent);
    	for(int i=0;i<values.length;i++) {
    		LOGGER.info("Add record " + i + " :" + (values[i]==0? "failed":"success"));
    	}
    	LOGGER.info("Total students is " + jdbc.totalRecord());
    	
    }
}
