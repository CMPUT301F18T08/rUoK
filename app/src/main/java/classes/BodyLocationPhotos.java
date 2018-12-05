package classes;

import android.widget.ImageView;

import java.util.ArrayList;

public class BodyLocationPhotos extends Photo {
    private ArrayList<Photo> bodyLocationPhotos = new ArrayList<>();

    public ArrayList<Photo> getBodyLocationPhoto() { return bodyLocationPhotos; }

    public void addFrontPhoto(Photo frontPhoto) { bodyLocationPhotos.add(frontPhoto); }
    public void addBackPhoto(Photo backPhoto) { bodyLocationPhotos.add(backPhoto); }
    public void addBodyLocationPhoto(Photo bodyLocationPhoto) { bodyLocationPhotos.add(bodyLocationPhoto);}
    public void deletePhoto(ImageView bodyLocationPhoto) { bodyLocationPhotos.remove(bodyLocationPhoto); }

}
