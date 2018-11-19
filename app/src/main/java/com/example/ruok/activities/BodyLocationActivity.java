// create dot activity - Author: Piyush Malaviya @Jul 11, 2015 from https://stackoverflow.com/questions/31360507/how-to-create-a-point-on-touch-of-a-particular-position-of-a-image-in-android
// isLongPress - Author: pbreak @Jan 6, 2014 from https://blog.csdn.net/pbreak/article/details/17919551

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
        boolean isLongClickModule = false;
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            float touchX = event.getX();
            float touchY = event.getY();
            bodyPartInput.setTextSize(3);

            isLongClickModule = isLongPressed(touchX, touchY,event.getX(), event.getY(),event.getDownTime() ,event.getEventTime(), 300 )
            if (isLongClickModule = true) {
              canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);
            }
            else {
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
        /* check if long press occur
         * @param lastX x_coordinate when press
         * @param lastY y_coordinate when press
         * @param thisX moved x_coordinate
         * @param thisY moved_y_coordinate
         * @param lastDownTime time when press
         * @param thisEventTime time when release
         * @param longPressTime time press
         * @param offsetX,offsetY variance by accident moving from the origin press location
         */
        private boolean isLongPressed(float lastX,float lastY, float thisX,float thisY, long lastDownTime,long thisEventTime, long longPressTime){
            float offsetX = Math.abs(thisX - lastX);
            float offsetY = Math.abs(thisY - lastY);
            long intervalTime = thisEventTime - lastDownTime;
            if(offsetX <= 2 && offsetY <= 2 && intervalTime >= longPressTime){
                return true;
            }
            return false;
        }

    }

    public void save(View view) {
        Intent finish_pointing = new Intent(this, ViewBodyLocationPhotosActivity.class);
        startActivity(finish_pointing);
    }
}
