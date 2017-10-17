package com.lab11.pratice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnotationTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Method[] methods = TotalCalculatorTest.class.getDeclaredMethods();
		TotalCalculatorTest obj = new TotalCalculatorTest();
		Arrays.stream(methods).forEach(method->{
			Test test = method.getAnnotation(Test.class);
			if(test==null)
				return;
			System.out.println("test method " + method.getName());
			try {
				System.out.println(method.invoke(obj, new Object[] {test.value()}));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
