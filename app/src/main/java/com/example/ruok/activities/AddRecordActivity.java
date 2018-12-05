package com.example.ruok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.controller.Response;
import com.example.ruok.controller.SaveOrUpdateUserTask;
import com.example.ruok.ui.ProfileBodyPhotoActivity;
import com.example.ruok.utils.ImageLoaderUtil;
import com.example.ruok.utils.JsonUser;
import com.example.ruok.utils.SpUtil;
import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

import classes.Photo;
import classes.Problem;
import classes.Record;

/**
 * AddRecordActivity
 * Usage: Patient can add a record to a problem.
 *
 * @version 1.1
 */

public class AddRecordActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CODE_LOCATION = 0x10;

    private Problem problem;
    private int problemIndex;
    private LatLng latLng;
    private String address;
    private EditText et_title;
    private EditText et_more_detail;
    private ImageButton ib_location;
    private EditText et_body_part;
    private ImageButton ib_camera;
    private ImageView iv_record_photo,iv_front_photo,iv_back_photo;

    private Button btn_save;
    private String body = "";
    private Integer bodyImage;
    private TextView tv_latLng;
    private String pathRecordPhoto;
    private String pathFrontPhoto;
    private String pathBackPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record2);
        initView();

        getData();
    }

    private void initView() {
        et_title = (EditText) findViewById(R.id.et_title);
        et_more_detail = (EditText) findViewById(R.id.et_more_detail);
        ib_location = (ImageButton) findViewById(R.id.ib_location);
        et_body_part = (EditText) findViewById(R.id.et_body_part);
        ib_camera = (ImageButton) findViewById(R.id.ib_camera);
        iv_record_photo = findViewById(R.id.iv_record_photo);
        iv_front_photo = findViewById(R.id.iv_front_photo);
        iv_back_photo = findViewById(R.id.iv_back_photo);
        btn_save = findViewById(R.id.btn_save);
        tv_latLng = findViewById(R.id.tv_latLng);

        ib_location.setOnClickListener(this);
        ib_camera.setOnClickListener(this);
        btn_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_location:
                startActivityForResult(new Intent(AddRecordActivity.this, MapsActivity.class), CODE_LOCATION);
                break;
            case R.id.ib_camera:
                startActivityForResult(new Intent(AddRecordActivity.this, ProfileBodyPhotoActivity.class), 11);
                break;
            case R.id.btn_save:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String title = et_title.getText().toString().trim();
        if (TextUtils.isEmpty(title)) {
            Toast.makeText(this, "title", Toast.LENGTH_SHORT).show();
            return;
        }

        String detail = et_more_detail.getText().toString().trim();
        if (TextUtils.isEmpty(detail)) {
            Toast.makeText(this, "detail", Toast.LENGTH_SHORT).show();
            return;
        }

        String part = et_body_part.getText().toString().trim();
        if (TextUtils.isEmpty(part)) {
            Toast.makeText(this, "body part", Toast.LENGTH_SHORT).show();
            return;
        }


        final Record record = new Record();
        record.setRecordTitle(title);
        record.setDetail(detail);
        record.setDate(new Date());
        //record.addPhoto(Photo);
        if (latLng != null) {
            record.setLocation(address);
            record.setLatitude(latLng.latitude);
            record.setLongitude(latLng.longitude);
        }

        record.setBodyLocation(body);

        problem.addRecord(record);

        JsonUser user = SpUtil.getCurrentUser();
        user.getProblems().remove(problemIndex);
        user.getProblems().add(problem);


        SaveOrUpdateUserTask task = new SaveOrUpdateUserTask();
        task.execute(user);
        task.setResponse(new Response<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(AddRecordActivity.this, result, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onError(String errorMsg) {
                Toast.makeText(AddRecordActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getData() {
        problem = (Problem) getIntent().getSerializableExtra("problem");
        problemIndex = getIntent().getIntExtra("problemIndex", -1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11 && RESULT_OK == resultCode) {
//            body = data.getStringExtra("body");
//            bodyImage = data.getIntExtra("bodyImage", R.mipmap.ic_body_head);
            pathRecordPhoto = data.getStringExtra("pathRecordPhoto");
            pathFrontPhoto = data.getStringExtra("pathFrontPhoto");
            pathBackPhoto = data.getStringExtra("pathBackPhoto");
            ImageLoaderUtil.display(AddRecordActivity.this,pathRecordPhoto,iv_record_photo);
            ImageLoaderUtil.display(AddRecordActivity.this,pathFrontPhoto,iv_front_photo);
            ImageLoaderUtil.display(AddRecordActivity.this,pathBackPhoto,iv_back_photo);

        } else if (requestCode == CODE_LOCATION && RESULT_OK == resultCode) {
            latLng = data.getParcelableExtra("latLng");
            address = data.getStringExtra("address");
            tv_latLng.setText("(" + latLng.latitude + "," + latLng.longitude + ")");
        }
    }

}
