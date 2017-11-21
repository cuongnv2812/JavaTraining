package org.javaClass.springexample;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {
	
	private final static Logger LOGGER=Logger.getLogger(HelloWorld.class);
	String message;
	
	@Autowired(required=true)
	@Qualifier("helloJavaClazz2")
	private HelloClazz clazz;
	
	
	private HelloClazz clazz1;
	
	public HelloClazz getClazz1() {
		return clazz1;
	}
	public void setClazz1(HelloClazz clazz1) {
		this.clazz1 = clazz1;
	}
	public HelloWorld() {
		// TODO Auto-generated constructor stub
	}
	public HelloWorld(String name,HelloClazz clazz) {
		message="From HelloWorld constructor:" + name + ":" + clazz.getMessage();
	}
	@Required
	public void setMessage(String message) {
		this.message=message;
	}
	public void setClazz(HelloClazz clazz) {
		this.clazz=clazz;
	}
	
	public void sayHello() {
		clazz.printMessage();
		LOGGER.info("From HelloWorld: " + message);
	}

}
