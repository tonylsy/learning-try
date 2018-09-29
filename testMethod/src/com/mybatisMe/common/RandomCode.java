package com.mybatisMe.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

public abstract class RandomCode {
	protected int height;//image height
	protected int width;//width
	private String code_context;
	protected int length;//context length
	
	protected String fontFamily;
	protected int fontSize;
	
	//color
	protected Color color;
	
	protected int harassLineNum;
	
	private Random random = new Random();
	//setting entrance
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getFontFamily() {
		return fontFamily;
	}
	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	public int getHarassLineNum() {
		return harassLineNum;
	}
	public void setHarassLineNum(int harassLineNum) {
		this.harassLineNum = harassLineNum;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Color getColor() {
		if(color==null) {
			color = new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));
		}
		return color;
	}
	/**
	 * return random code
	 * @return
	 */
	public String getCode() {
		return code_context;
	}
	protected void Setcode_context(String code_context){
		this.code_context = code_context;
	}
	public RandomCode(int height, int width, int length, String fontFamily, int fontSize,Color color) {
		this.height = height;
		this.width = width;
		this.length = length;
		this.fontFamily = fontFamily;
		this.fontSize = fontSize;
		this.color = color;
	}
	public RandomCode(int height, int width, int length, String fontFamily, int fontSize) {
		this.height = height;
		this.width = width;
		this.length = length;
		this.fontFamily = fontFamily;
		this.fontSize = fontSize;
	}
	/**
	 * set the image size and code length
	 * @param height
	 * @param width
	 * @param length
	 */
	public RandomCode(int height, int width, int length) {
		this.height = height;
		this.width = width;
		this.length = length;
	}
	/**
	 * just set code length
	 * @param length
	 */
	public RandomCode(int length) {
		this.length = length;
	}
	/**
	 * constructor with no parameter
	 */
	public RandomCode() {
	}
	/**
	 * create code
	 * @param length
	 * @return
	 */
	protected abstract String createCode(int length);
	
	/**
	 * create font style
	 * @return
	 */
	protected Font createFont() {
		if(fontFamily == null) {
			fontFamily = "Times New Roman";
		}
		if(fontSize == 0) {
			fontSize = 18;
		}
		return new Font(fontFamily,Font.CENTER_BASELINE,fontSize);
	}
	
	/**
	 * drowing harassline
	 * @param g
	 */
    private void drowLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }
	
	/**
	 * create return img
	 * @param length
	 * @return
	 */
	public ByteArrayOutputStream createByteArrayOutputStream(){
		BufferedImage bufferImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		Graphics graphics = bufferImage.getGraphics();
		
		Font font = createFont();
		Color color = getColor();
		graphics.setFont(font);
		graphics.setColor(color);
		
		return null;
	};
	
	
}
