package com.example.ruok;
import org.junit.Test;


import java.util.Date;

import classes.Record;

import static org.junit.Assert.*;

public class RecordTest {
    @Test
    public void testSetComment() {
        Record record = new Record("a","b",new Date(),"hi");
        record.setComment("hello world");
        assertEquals("hello world",record.getComment());
    }


}
