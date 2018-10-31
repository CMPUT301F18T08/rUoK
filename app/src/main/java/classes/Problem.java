package classes;

import java.util.ArrayList;
import java.util.Date;

public class Problem {
    private Date date;
    private String title;
    private String description;
    private ArrayList<Record> records = new ArrayList<>();

    // Date func
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    // title func
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //description func
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // Record func
    public void addRecord(Record record){
        records.add(record);
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void deleteRecord(Record record){
        records.remove(record);
    }

}
