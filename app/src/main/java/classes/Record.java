package classes;

import android.location.Location;

import java.io.File;
import java.net.URL;
import java.util.Date;

public class Record {
    private String recordTitle;
    private String patientName;
    private String doctorName;
    private Date date;
    private String comment;
    private String bodyLocation;
    private File photoGraph;
    private Location location;

    public Record(){

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

    public String getBodyLocation() { return bodyLocation; }

    public File getPhotoGraph() { return photoGraph; }

    public Location getLocation() { return location; }

    public String getRecordTitle() { return recordTitle; }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setBodyLocation(String bodyLocation) { this.bodyLocation = bodyLocation; }

    public void setPhotoGraph() { this.photoGraph = photoGraph; }

    public void setLocation() { this.location = location; }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setRecordTitle(String recordTitle) { this.recordTitle = recordTitle; }

}
