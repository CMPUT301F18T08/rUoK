package com.example.ruok;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import classes.Problem;
import classes.Record;
import static org.junit.Assert.*;

public class ProblemTest {

    @Test
    public void addRecordTest(){
        Problem problem = new Problem();
        Record record = new Record();
        problem.addRecord(record);
        assertEquals(record,problem.getRecords().get(0));
    }

    @Test
    public void deleteRecordTest(){
        ArrayList A = new ArrayList();
        Problem problem = new Problem();
        Record record = new Record();
        problem.addRecord(record);
        assertEquals(record,problem.getRecords().get(0));
        problem.deleteRecord(record);
        assertEquals(A,problem.getRecords());
    }
}
