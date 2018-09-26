package com.abstractKnowledge;

public class MainTest {
	public static void main(String[] args) throws Exception {
		//只能利用够构造器赋值，实例化父类，则无法调用子类中的方法
		Shape shape_tr = new Triangle("red",2.33f,2.33f,2.33f);
		//shape_tr.show();
		System.out.println(shape_tr.getLength());
		System.out.println(shape_tr.getColor());
		
		ShapeService ss = new ShapeServiceImpl();
		System.out.println(ss.getColor());
	}
}
