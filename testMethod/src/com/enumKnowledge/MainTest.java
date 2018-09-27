package com.enumKnowledge;

import com.abstractKnowledge.LambaOne;
import com.abstractKnowledge.Shape;
import com.abstractKnowledge.ShapeService;
import com.abstractKnowledge.ShapeServiceImpl;
import com.abstractKnowledge.Triangle;

public class MainTest {
	public static void main(String[] args) throws Exception {
		//enum
		System.out.println(Season.SPRING.getValue());
		
		for(Season season : Season.values()) {
			System.out.println(">>>>>>>"+season.getValue());
			System.out.println(Enum.valueOf(Season.class, "SPRING"));
		}
	}
}
