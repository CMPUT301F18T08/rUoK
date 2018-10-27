package com.example.ruok;
import org.junit.Test;

import java.util.Date;

import classes.Problem;
import classes.Record;
import static org.junit.Assert.*;

public class ProblemTest {

    @Test
    public void addRecordTest(){
        Problem problem = new Problem();
        Record record = new Record("a","b",new Date(),"hi");
        problem.addRecord(record);
        assertEquals(record,problem.getRecords().get(0));
    }

    @Test
    public void deleteRecordTest(){
        Problem problem = new Problem();
        Record record = new Record("a","b",new Date(),"hi");
        problem.addRecord(record);
        assertEquals(record,problem.getRecords().get(0));
        problem.deleteRecord(record);

        Record record1 = new Record("a","b",new Date(),"hello");
        problem.addRecord(record1);
        assertEquals(record1,problem.getRecords().get(0));
    }
}
