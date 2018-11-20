
package classes;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Date;

/**
 * Record class
 * @author  Yuhan Ye
 * @version 1.1
 */
public class Record {
    private String recordTitle;
    private String patientName;
    private String doctorName;
    private Date date;
    private String comment;
    private String bodyLocation;
    private ArrayList<Photo> photos = new ArrayList<Photo>(10);
    private String location;

    /**
     * method to get comment
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * method to get doctor name
     * @return doctorName this is the username of the care provider
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * method to get date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * method to get patient name
     * @return patientName this is the username of the patient
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * method to get body location
     * @return bodyLocation
     */
    public String getBodyLocation() { return bodyLocation; }

    /**
     * method to get an array list of photos
     * @return photos
     */
    public ArrayList<Photo> getPhotos() { return photos; }

    /**
     * method to get location
     * @return location this is the geolocation
     */
    public String getLocation() { return location; }

    /**
     * method to get record title
     * @return recordTitle
     */
    public String getRecordTitle() { return recordTitle; }

    /**
     * method to set date
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * method to set body location
     * @param bodyLocation
     */
    public void setBodyLocation(String bodyLocation) { this.bodyLocation = bodyLocation; }

    /**
     * method to set location
     * @param location
     */
    public void setLocation(String location) { this.location = location; }

    /**
     * method to set comment
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * method to set doctor name
     * @param doctorName
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * method to set patient name
     * @param patientName
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * method to set record title
     * @param recordTitle
     */
    public void setRecordTitle(String recordTitle) { this.recordTitle = recordTitle; }

    /**
     * method to add photo to the photo array list
     * @param photo
     */
    public void addPhoto(Photo photo) { photos.add(photo); }

    /**
     * method to delete photo in the photo array list
     * @param photo
     */
    public void deletePhoto(Photo photo) { photos.remove(photo); }

}