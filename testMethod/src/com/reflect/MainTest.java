package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTest {

	public static void main(String[] args) {
		//资料：http://ifeve.com/java-reflection/
		//https://blog.csdn.net/t131452n/article/details/78307899#%E4%B8%80%E4%BB%80%E4%B9%88%E6%98%AF%E5%8F%8D%E5%B0%84what
		
		//获取所有类下的方法名称
		/*Method[] methods = ArithmeticalOperation.class.getMethods();
		for(Method method : methods) {
			System.out.println("方法名称：>>"+method.getName());
		}*/
		
		//获取类名
		/*try {
			Class clazz = Class.forName("com.reflect.ArithmeticalOperation");
			System.out.println("类名+包：》》"+clazz.getName());
			System.out.println("类名：》》"+clazz.getSimpleName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//构造函数实例化
		/*try {
			Constructor clazz= ArithmeticalOperation.class.getConstructor(String.class);
			ArithmeticalOperation arithmeticalOperation = (ArithmeticalOperation)clazz.newInstance("ArithmeticalOperation");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
