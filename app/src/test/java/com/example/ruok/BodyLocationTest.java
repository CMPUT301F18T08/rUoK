package com.example.ruok;

import org.junit.Test;

import java.util.ArrayList;

import classes.Body;
import classes.BodyLocation;
import classes.Photo;

import static org.junit.Assert.assertEquals;

public class BodyLocationTest {

    @Test
    public void addFrontPhotoTest() {
        BodyLocation body = new BodyLocation();
        Photo frontPhoto = new Photo();
        body.addFrontPhoto(frontPhoto);
        assertEquals(frontPhoto,body.getBodyLocationPhoto().get(0));
    }

    @Test
    public void addBackPhotoTest() {
        BodyLocation body = new BodyLocation();
        Photo backPhoto = new Photo();
        body.addBackPhoto(backPhoto);
        assertEquals(backPhoto,body.getBodyLocationPhoto().get(0));

    }

    @Test
    public void addBodyLocationPhotoTest() {
        BodyLocation body = new BodyLocation();
        Photo photo = new Photo();
        body.addBodyLocationPhoto(photo);
        assertEquals(photo,body.getBodyLocationPhoto().get(0));

    }

    @Test
    public void deletePhotoTest() {
        ArrayList photos = new ArrayList();
        Photo photo = new Photo();
        BodyLocation body = new BodyLocation();
        body.addBodyLocationPhoto(photo);
        assertEquals(photo,body.getBodyLocationPhoto().get(0));
        body.deletePhoto(photo);
        assertEquals(photos,body.getBodyLocationPhoto());
    }
}