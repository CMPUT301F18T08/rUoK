package classes;

import java.util.ArrayList;
import java.util.Date;

public class Record {
    private String recordTitle;
    private String patientName;
    private String doctorName;
    private Date date;
    private String comment;
    private String bodyLocation;
    private ArrayList<Photo> photos = new ArrayList<Photo>(10);
    private String location;


    public Record(String d, String a, String b, Date date, String hi, String foot, String my_image, String location){

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

    public ArrayList<Photo> getPhotos() { return photos; }

    public String getLocation() { return location; }

    public String getRecordTitle() { return recordTitle; }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setBodyLocation(String bodyLocation) { this.bodyLocation = bodyLocation; }

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

    public void addPhoto(Photo photo) { photos.add(photo); }

    public void deletePhoto(Photo photo) { photos.remove(photo); }

}
