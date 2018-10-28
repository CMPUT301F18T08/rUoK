package classes;

import java.util.Date;

public class Record {
    private String patientName;
    private String doctorName;
    private Date date;
    private String comment;

    public Record(String patientName, String doctorName, Date date, String comment){
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.comment = comment;
    }
    public String getComment() {
        return comment;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public Date getDate() {
        return date;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

}
