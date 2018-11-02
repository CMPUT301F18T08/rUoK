package com.example.ruok;

import org.junit.Test;

import java.util.Date;

import classes.CareProvider;
import classes.Patient;
import classes.Record;

import static org.junit.Assert.assertEquals;

public class CareProviderTest {

    @Test
    public void addPatientTest(){
        CareProvider careProvider = new CareProvider();
        Patient patient = new Patient();
        careProvider.addPatient(patient);
        assertEquals(patient,careProvider.getPatients().get(0));
    }
      @Test
    public void addProblemTest(){
        Patient joseph = new Patient();
        Problem problem = new Problem();
        joseph.addProblem(problem);
        assertEquals(problem,joseph.getProblems().get(0));
    }
    @Test
    public void addCommentTest() {
        CareProvider careProvider = new CareProvider();
        String newComment = "sdd";
        Record record = new Record("d", "a", "b", new Date(), "hi", "foot", "my_image", "location");
        careProvider.addComment(newComment, record);
        assertEquals(newComment,record.getComment());

    }
}
