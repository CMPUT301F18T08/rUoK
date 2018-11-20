package com.example.ruok.activities;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import com.example.ruok.R;
import android.provider.MediaStore;
import java.io.ByteArrayOutputStream;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * AddPhotoActivity
 * Usage: Patient can add a photo to a record
 *
 * @version 1.1
 */

public class AddPhotoActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnSave;
    Bitmap bitmap;
    private static final int PHOTO_FROM_GALLERY = 1;
    private static final int PHOTO_FROM_CAMERA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);

        btnSave = findViewById(R.id.addPhotoSearch);
        //imageView = findViewById(R.id.addPhotoaddImage);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        } else {
            Toast.makeText(AddPhotoActivity.this, "Unable To Get Photo From Camera", Toast.LENGTH_LONG).show();
        }

    }
    public void savePicture(View view){

        Intent returnPhotoIntent = new Intent();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        returnPhotoIntent.putExtra("image", byteArray);
        setResult(1, returnPhotoIntent);
        finish();

    }
    //get photo from gallery
    public void gallery(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PHOTO_FROM_GALLERY);
    }
}
