// create dot activity - Author: Piyush Malaviya @Jul 11,2015 from https://stackoverflow.com/questions/31360507/how-to-create-a-point-on-touch-of-a-particular-position-of-a-image-in-android

package com.example.ruok.activities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.ruok.R;

public class BodyLocationActivity extends AppCompatActivity {
    private ImageView bodyLocationImage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_location);
        bodyLocationImage = (ImageView) findViewById(R.id.imageView8);
        bodyLocationImage.setOnTouchListener(new PicOnTouchListener());
    }
    private class PicOnTouchListener implements android.view.View.OnTouchListener {
        final Bitmap bitmap = ((BitmapDrawable) bodyLocationImage.getDrawable()).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            float touchX = event.getX();
            float touchY = event.getY();
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            canvas.drawCircle(touchX, touchY, 2, paint);    // for circle dot
            //canvas.drawPoint(touchX, touchY, paint);  // for single point
            bodyLocationImage.setImageBitmap(bitmap);
            bodyLocationImage.invalidate();
            return true;
        }
    }
}
