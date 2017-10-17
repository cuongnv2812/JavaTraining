package com.lab11.pratice;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {
	
	private static void explore(Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Class clazz=obj.getClass();
		System.out.println("Clazz name:" + clazz.getName());
		Field field=clazz.getDeclaredField("TOTAL");
		field.setAccessible(true);
		System.out.println("Total value is "+ field.get(obj));
		
		Field modifierField=Field.class.getDeclaredField("modifiers");
		modifierField.setAccessible(true);
		modifierField.setInt(field, field.getModifiers()&~Modifier.FINAL);
		
		field.setInt(obj, 23);
		System.out.println("Total value after change using Reflection: " + field.get(obj));
		
		/*Method method = clazz.getDeclaredMethod("getTotal", new Class[]{int.class});
		method.setAccessible(true);
		System.out.println("Method return value =" + method.invoke(obj, new Object[]{5}));*/
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
		Object obj = TotalCalculator.class.newInstance();
		explore(obj);
	}

}
