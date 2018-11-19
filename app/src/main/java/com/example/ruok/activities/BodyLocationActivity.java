// create dot activity - Author: Piyush Malaviya @Jul 11,2015 from https://stackoverflow.com/questions/31360507/how-to-create-a-point-on-touch-of-a-particular-position-of-a-image-in-android

package com.example.ruok.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruok.R;

public class BodyLocationActivity extends AppCompatActivity {
    private ImageView bodyLocationImage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_location_photos);
        bodyLocationImage = (ImageView) findViewById(R.id.imageView8);
        bodyLocationImage.setOnTouchListener(new PicOnTouchListener());
        Intent intent = getIntent();
    }
    private class PicOnTouchListener implements android.view.View.OnTouchListener {
        final Bitmap bitmap = ((BitmapDrawable) bodyLocationImage.getDrawable()).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
        EditText bodyPartInput = (EditText) findViewById(R.id.bodyPart);
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            float touchX = event.getX();
            float touchY = event.getY();
            bodyPartInput.setTextSize(3);
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            canvas.drawCircle(touchX, touchY, 5, paint);    // for circle dot
            //canvas.drawPoint(touchX, touchY, paint);  // for single point
            bodyLocationImage.setImageBitmap(bitmap);
            bodyLocationImage.invalidate();
            bodyPartInput.setGravity(Gravity.CENTER);
            bodyPartInput.setText("");
            return true;
        }
    }

    public void save(View view) {
        Intent finish_pointing = new Intent(this, ViewBodyLocationPhotosActivity.class);
        startActivity(finish_pointing);
    }
}
