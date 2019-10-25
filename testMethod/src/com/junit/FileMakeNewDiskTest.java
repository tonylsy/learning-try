package com.junit;

import com.file.FileMakeNewDisk;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
