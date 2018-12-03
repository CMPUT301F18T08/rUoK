package classes;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.searchbox.annotations.JestId;

/**
 * Problem class
 *
 * @author Yuhan Ye
 * @version 1.1
 */
public class Problem implements Serializable {
    @JestId
    private String id;
    private Date date;
    private String title;
    private String description;
    private List<String> comments = new ArrayList<>();
    private ArrayList<Record> records = new ArrayList<>();

    /**
     * method to set date
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * method to get date
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * method to get required string format of date in
     *
     * @return String format of date
     */
    public static String DateToString() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"), Locale.getDefault());
        return format.format(date);
    }

    /**
     * method to get title
     *
     * @return title problem title
     */
    public String getTitle() {
        return title;
    }

    /**
     * method to set title
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * method to get description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * method to set description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * method to add record in the array list of records
     *
     * @param record
     */
    public void addRecord(Record record) {
        records.add(record);
    }

    /**
     * method to get the array list of records
     *
     * @return records
     */
    public ArrayList<Record> getRecords() {
        return records;
    }

    /**
     * method to delete record from the array list of records
     *
     * @param record
     */
    public void deleteRecord(Record record) {
        records.remove(record);
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
