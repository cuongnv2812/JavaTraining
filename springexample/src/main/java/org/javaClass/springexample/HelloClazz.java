package org.javaClass.springexample;

import java.util.List;

public class HelloClazz {
	
	public String message;
	private List<JavaClazz> clazzes;

	
	public List<JavaClazz> getClazzes() {
		return clazzes;
	}
	public void setClazzes(List<JavaClazz> clazzes) {
		this.clazzes = clazzes;
	}
	public HelloClazz() {
		message="Message in contructor";
	}
	public HelloClazz(int person) {
		message="From constructor : Say hello " + person;
	}
	public HelloClazz(HelloClazz clazz) {
		message=clazz.message;
	}
	
	public void setMessage(String message) {
		this.message="Call from Setter:" + message;
	}
	public String getMessage() {
		return message;
	}
	public void printMessage() {
		System.out.println("YourMessage: " + message);
	}
	private void initMessage() {
		System.out.println("Calling init method....");
		message="From init method : Say Hello Bean";
	}
	private void release() {
		message=null;
		System.out.println("Message is null");
	}
}
