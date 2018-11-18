package classes;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Problem implements Serializable{
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

    public static String DateToString(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"), Locale.getDefault());
        return format.format(date);
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
