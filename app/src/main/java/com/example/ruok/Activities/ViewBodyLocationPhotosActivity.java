package com.example.ruok.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ruok.R;

/**
 * ViewBodyLocationPhotosActivity
 * Usage: Handling photo
 *
 * @version 1.1
 */

public class ViewBodyLocationPhotosActivity extends AppCompatActivity {
    private Button addPhoto_Button;
    private ImageView frontPhoto;
    private ImageView backPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_location);
        addPhoto_Button = (Button)findViewById(R.id.addPhoto);
        frontPhoto = (ImageView)findViewById(R.id.FrontPhoto);
        backPhoto = (ImageView)findViewById(R.id.BackPhoto);

        addPhoto_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_addBodyPhoto = new Intent(ViewBodyLocationPhotosActivity.this, AddPhotoActivity.class);
                startActivity(intent_addBodyPhoto);
            }
        });

        frontPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_frontPhoto = new Intent(ViewBodyLocationPhotosActivity.this, BodyLocationActivity.class);
                startActivity(intent_frontPhoto);
            }
        });

        backPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_backPhoto = new Intent(ViewBodyLocationPhotosActivity.this, BodyLocationActivity.class);
                startActivity(intent_backPhoto);
            }
        });

    }

    //public void browseBodyLocationPhoto(View view) {
      //  Intent intent = new Intent(ViewBodyLocationPhotosActivity.this, BodyLocationActivity.class);
        //startActivity(intent);
    //}

}