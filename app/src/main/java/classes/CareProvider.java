package classes;

import java.util.ArrayList;

public class CareProvider extends User {
    private ArrayList<Patient> patients;
    public void addPatient(Patient patient){
        patients.add(patient);
    }
    public void addComment(String comment, Record record){
        record.setComment(comment);
    }
}
