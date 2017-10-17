package com.lab11.pratice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Test {
	short value() default 0;
}
public class TotalCalculatorTest {
	private int TOTAL=3;
	@Test(39)
	long getTotal(short value) {
		return TOTAL+value;
	}
	@Test(100)
	public void print(short value) {
		System.out.println("gia tri them vao la: "+ value);
	}
}
