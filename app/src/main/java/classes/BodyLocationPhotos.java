package classes;

import java.util.ArrayList;

// This should be a abstract class
// define as a class for testing issue
// location of body that patient could record using photos
public class BodyLocationPhotos extends Photo {
    private ArrayList<Photo> bodyLocationPhotos = new ArrayList<>();

    public ArrayList<Photo> getBodyLocationPhoto() { return bodyLocationPhotos; }

    public void addFrontPhoto(Photo frontPhoto) { bodyLocationPhotos.add(frontPhoto); }
    public void addBackPhoto(Photo backPhoto) { bodyLocationPhotos.add(backPhoto); }
    public void addBodyLocationPhoto(Photo bodyLocationPhoto) { bodyLocationPhotos.add(bodyLocationPhoto);}
    public void deletePhoto(Photo bodyLocationPhoto) { bodyLocationPhotos.remove(bodyLocationPhoto); }

}
