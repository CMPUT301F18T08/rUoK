package com.example.ruok;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import classes.Patient;
import classes.Problem;
import classes.Record;
import static org.junit.Assert.*;
public class PatientTest {

    @Test
    public void addProblemTest(){
        Patient joseph = new Patient();
        Problem problem = new Problem();
        joseph.addProblem(problem);
        assertEquals(problem,joseph.getProblems().get(0));
    }

    @Test
    public void deleteProblemTest(){
        ArrayList A = new ArrayList();
        Patient joseph = new Patient();
        Problem problem = new Problem();
        joseph.addProblem(problem);
        assertEquals(problem,joseph.getProblems().get(0));
        joseph.deleteProblem(problem);
        assertEquals(A,joseph.getProblems());
    }

    @Test
    public void editProblemTest(){
        Patient joseph = new Patient();
        Problem problem = new Problem();
        joseph.addProblem(problem);
        assertEquals(problem,joseph.getProblems().get(0));
        String title = "I am dead";
        Date date = new Date();
        String description = "tooth ache";
        joseph.editProblem(problem,title,date,description);
        assertEquals(title,problem.getTitle());
        assertEquals(date,problem.getDate());
        assertEquals(description,problem.getDescription());
    }

    @Test
    public void addRecordTest(){

        Patient joseph = new Patient();
        Problem problem = new Problem();
        Record record = new Record("d", "a", "b", new Date(), "hi", "foot", "my_image", "location");
        joseph.addProblem(problem);
        joseph.addRecord(problem,record);
        assertEquals(record,joseph.getProblems().get(0).getRecords().get(0));

    }
}
