package com.mybatisMe.common;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RandomCodeTest {
	RandomCodeOnlyNumber randomCodeOnlyNumber = new RandomCodeOnlyNumber();
	@Test
	void testCreateFont() {
		Font font = randomCodeOnlyNumber.createFont();
		assertNotNull(font);
		assertEquals(font.getFamily(),"Times New Roman");
		assertEquals(font.getSize(),18);
		
		randomCodeOnlyNumber.setFontFamily("Serif");
		Font font2 = randomCodeOnlyNumber.createFont();
		assertNotNull(font2);
		assertEquals(font2.getFamily(),"Serif");
		assertEquals(font2.getSize(),18);
		
		
		randomCodeOnlyNumber = new RandomCodeOnlyNumber();
		randomCodeOnlyNumber.setFontSize(20);
		Font font3 = randomCodeOnlyNumber.createFont();
		assertNotNull(font3);
		assertEquals(font3.getFamily(),"Times New Roman");
		assertEquals(font3.getSize(),20);
		
	}

}
