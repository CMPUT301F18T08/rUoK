package com.example.ruok;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import classes.Patient;
import classes.Problem;
import classes.Record;
import static org.junit.Assert.*;
public class CareProviderTest {
	@Test
    public void addPatientTest(){
        Patient yasuo = new Patient();
        Problem problem = new Problem();
        yasuo.addProblem(problem);
        assertEquals(problem,yasuo.getProblems().get(0));
    }
    @Test
    public void addCommentTest(){

        Patient yasuo = new Patient();
        Problem problem = new Problem();
        Record record = new Record();
        yasuo.addProblem(problem);
        yasuo.addRecord(problem,record);
        record.setComment("Hasagi");
        assertEquals("Hasagi",record.getComment());
    }
}
