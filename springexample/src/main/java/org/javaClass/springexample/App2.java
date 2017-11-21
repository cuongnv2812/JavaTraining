package org.javaClass.springexample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		HelloClazz mybean = (HelloClazz) ctx.getBean("bean2");
		mybean.printMessage();
		
		HelloClazz mybean2 = (HelloClazz) ctx.getBean("bean2");
		mybean.printMessage();
		System.out.println(mybean==mybean2);
	}
}
