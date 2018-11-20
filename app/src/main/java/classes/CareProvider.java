package classes;

import java.util.ArrayList;

/**
 * CareProvider class
 * @author  Yuhan Ye
 * @version 1.1
 */
public class CareProvider extends User {
    private ArrayList<Patient> patients = new ArrayList<>();

    /**
     * method to get patients list
     * @return patients
     */
    public ArrayList<Patient> getPatients() {return patients;}

    /**
     * method to add patient to the list of patient
     * @param patient patient is the user
     */
    public void addPatient(Patient patient){
        patients.add(patient);
    }

    /**
     * method to add comment to the record
     * @param comment every record has a comment. the comment can be optional
     * @param record  record is associated to a problem
     */
    public void addComment(String comment, Record record){
        record.setComment(comment);
    }

}