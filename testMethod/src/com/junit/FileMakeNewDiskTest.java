package com.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.file.FileMakeNewDisk;

class FileMakeNewDiskTest {
	private FileMakeNewDisk fileMakeNewDisk = new FileMakeNewDisk();
	@Test
	void testDivide() {
		int rs = fileMakeNewDisk.divide(2, 1);
		assertEquals(2, rs);
	}
	@Test
	void testadd() {
		int rs = fileMakeNewDisk.add(2, 1);
		assertEquals(2, rs);
	}
}
