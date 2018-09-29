package com.mybatisMe.common;

import java.awt.Color;
import java.util.Random;

public class RandomCodeOnlyNumber extends RandomCode{
	protected Random random;
	public String createCode(int length) {
		return null;
	}
	public RandomCodeOnlyNumber(int height, int width, int length, String fontFamily, int fontSize) {
		super(height, width, length, fontFamily, fontSize);
	}
	/**
	 * set the image size and code length
	 * @param height
	 * @param width
	 * @param length
	 */
	public RandomCodeOnlyNumber(int height, int width, int length) {
		super(height,width,length);
	}
	/**
	 * just set code length
	 * @param length
	 */
	public RandomCodeOnlyNumber(int length) {
		super(length);
	}
	/**
	 * constructor with no parameter
	 */
	public RandomCodeOnlyNumber() {
		super();
	}
	public RandomCodeOnlyNumber(int height, int width, int length, String fontFamily, int fontSize,Color color) {
		super(height, width, length, fontFamily, fontSize,color);
	}
}
