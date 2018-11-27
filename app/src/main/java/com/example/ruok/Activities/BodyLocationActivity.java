// create dot activity - Author: Piyush Malaviya @Jul 11, 2015 from https://stackoverflow.com/questions/31360507/how-to-create-a-point-on-touch-of-a-particular-position-of-a-image-in-android
// isLongPress - Author: pbreak @Jan 6, 2014 from https://blog.csdn.net/pbreak/article/details/17919551
// Android Alert Dialog Box with yes and now - Author: Android Hari @Jan 18,2016 https://www.youtube.com/watch?v=3CotB4pclTw
package com.example.ruok.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ruok.R;

import classes.BodyLocationPhotos;

public class BodyLocationActivity extends AppCompatActivity {
    private ImageView bodyLocationImage = null;
    private BodyLocationPhotos bodyLocationPhotos;
    private Button delete_button;
    private Button save_button;
    private Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_and_back_photo);
        bodyLocationImage = findViewById(R.id.frontBackPhotoImage);
        bodyLocationImage.setOnTouchListener(new PicOnTouchListener());
        delete_button = (Button) findViewById(R.id.deletePhoto);
        save_button = (Button) findViewById(R.id.savePhoto);
        back_button = (Button) findViewById(R.id.frontBackPhotoBack);
        Intent intent = getIntent();
    }

    public void delete(View view){
                bodyLocationPhotos.deletePhoto(bodyLocationImage);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(BodyLocationActivity.this);
                alertDialog.setMessage("Do you want to delete this photo ?").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                Toast.makeText(BodyLocationActivity.this, "Body photo deleted", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(BodyLocationActivity.this, ViewBodyLocationPhotosActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert = alertDialog.create();
                alert.setTitle("Delete Photo Warning");
                alert.show();
            }

    public void savephoto(View view){
                Intent intent = new Intent(BodyLocationActivity.this,ViewBodyLocationPhotosActivity.class);
                startActivity(intent);
            }

    public void back(View view){
                Intent intent = new Intent(BodyLocationActivity.this,ViewBodyLocationPhotosActivity.class);
                startActivity(intent);
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
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(Color.RED);


            isLongClickModule = isLongPressed(touchX, touchY, event.getX(), event.getY(), event.getDownTime(), event.getEventTime(), 300);
            if (isLongClickModule == false) {
                canvas.drawCircle(touchX, touchY, 5, paint);    // for circle dot
                //canvas.drawPoint(touchX, touchY, paint);  // for single point
                bodyLocationImage.setImageBitmap(bitmap);
                bodyLocationImage.invalidate();
                bodyPartInput.setGravity(Gravity.CENTER);
                bodyPartInput.setText("");
            }
            else {
                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            }
            return true;
        }
        /*check if long press occur
         * @param lastX x_coordinate when press
         * @param lastY y_coordinate when press
         * @param thisX moved x_coordinate
         * @param thisY moved_y_coordinate
         * @param lastDownTime time when press
         * @param thisEventTime time when release
         * @param longPressTime time press
         * @param offsetX,offsetY variance by accident moving from the origin press location
         */
        private boolean isLongPressed(float lastX,float lastY,
                                      float thisX,float thisY,
                                      long lastDownTime,long thisEventTime,
                                      long longPressTime){
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
