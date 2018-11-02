package com.example.ruok;
import android.location.Location;

import com.google.android.gms.maps.LocationSource;

import org.junit.Test;


import java.io.File;
import java.net.URL;
import java.util.Date;

import classes.Record;

import static org.junit.Assert.*;

public class RecordTest {
    @Test
    public void testSetComment() {
        Record record = new Record("d","a","b",new Date(),"hi", "foot", new File("my_image.jpg"), new Location("PRINCETON_NJ", 40.366633, 74.640832));
        record.setComment("hello world");
        assertEquals("hello world",record.getComment());
    }


}
