package classes;

import java.util.ArrayList;

public class BodyLocation {
    private ArrayList<Photo> bodyLocationPhotos = new ArrayList<>();
    private Photo frontPhoto;
    private Photo backPhoto;

    public ArrayList<Photo> getBodyLocationPhoto() { return bodyLocationPhotos; }

    public void addFrontPhoto(Photo frontPhoto) { bodyLocationPhotos.add(frontPhoto); }
    public void addBackPhoto(Photo backPhoto) { bodyLocationPhotos.add(backPhoto); }
    public void addBodyLocationPhoto(Photo bodyLocationPhoto) { bodyLocationPhotos.add(bodyLocationPhoto);}
    public void deletePhoto(Photo bodyLocationPhoto) { bodyLocationPhotos.remove(bodyLocationPhoto); }
}
