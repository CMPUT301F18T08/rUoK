package com.example.ruok;
import android.location.Location;

import com.google.android.gms.maps.LocationSource;

import org.junit.Test;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import classes.Photo;
import classes.Record;

import static org.junit.Assert.*;

public class RecordTest {
    @Test
    public void testSetComment() {
        Record record = new Record();
        record.setComment("hello world");
        assertEquals("hello world",record.getComment());
    }

    @Test
    public void addPhotoTest() {
        Record record = new Record();
        Photo photo = new Photo();
        record.addPhoto(photo);
        assertEquals(photo,record.getPhotos().get(0));
    }

    @Test
    public void deletePhotoTest() {
        Record record = new Record();
        ArrayList photoList = new ArrayList();
        Photo photo = new Photo();
        record.addPhoto(photo);
        assertEquals(photo,record.getPhotos().get(0));
        record.deletePhoto(photo);
        assertEquals(photoList,record.getPhotos());
    }
}