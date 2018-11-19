package classes;

import java.io.File;
import java.util.ArrayList;

import android.graphics.Bitmap;

public class Photo {
    private Bitmap photoGraph;
    private String photo_id;


    public Bitmap getPhotoGraph() {
        return photoGraph;
    }
    public String getPhoto_id() {
        return photo_id;
    }
    public void setPhotoGraph(Bitmap photoGraph) { this.photoGraph = photoGraph; }
    public void setPhoto_id(String photo_id) {
        this.photo_id = photo_id;
    }


}