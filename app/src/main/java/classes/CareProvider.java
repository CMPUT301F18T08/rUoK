package classes;

import java.util.ArrayList;

public class CareProvider extends User {
    private ArrayList<Patient> patients = new ArrayList<>();

//    public CareProvider(String userName, String password, String gender, String email, String phoneNumber, String userType){
//    this.userName = userName;
//    this.password = password;
//    this.gender = gender;
//    this.email = email;
//    this.phoneNumber = phoneNumber;
//    this.userType = userType;
//
//
//    }

    public ArrayList<Patient> getPatients() {return patients;}
    public void addPatient(Patient patient){
        patients.add(patient);
    }
    public void addComment(String comment, Record record){
        record.setComment(comment);
    }
}