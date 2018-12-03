package com.example.ruok.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ruok.R;

public class ProfileBodyPhotoActivity extends AppCompatActivity implements View.OnClickListener {

    private View view_head;
    private View view_left_hand;
    private View view_right_hand;
    private View view_left_arm;
    private View view_right_arm;
    private View view_chest;
    private View view_abdomen;
    private View view_left_leg;
    private View view_right_leg;
    private View view_left_foot;
    private View view_right_foot;

    private String bodyPart;
    private Integer bodyImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_location_click);
        initView();
    }

    private void initView() {
        view_head = (View) findViewById(R.id.view_head);
        view_left_hand = (View) findViewById(R.id.view_left_hand);
        view_right_hand = (View) findViewById(R.id.view_right_hand);
        view_left_arm = (View) findViewById(R.id.view_left_arm);
        view_right_arm = (View) findViewById(R.id.view_right_arm);
        view_chest = (View) findViewById(R.id.view_chest);
        view_abdomen = (View) findViewById(R.id.view_abdomen);
        view_left_leg = (View) findViewById(R.id.view_left_leg);
        view_right_leg = (View) findViewById(R.id.view_right_leg);
        view_left_foot = (View) findViewById(R.id.view_left_foot);
        view_right_foot = (View) findViewById(R.id.view_right_foot);

        view_head.setOnClickListener(this);
        view_left_hand.setOnClickListener(this);
        view_right_hand.setOnClickListener(this);
        view_left_arm.setOnClickListener(this);
        view_right_arm.setOnClickListener(this);
        view_chest.setOnClickListener(this);
        view_abdomen.setOnClickListener(this);
        view_left_leg.setOnClickListener(this);
        view_right_leg.setOnClickListener(this);
        view_left_foot.setOnClickListener(this);
        view_right_foot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.view_head:
                bodyPart = "head";
                bodyImage = R.mipmap.ic_body_head;
//                Toast.makeText(this, "头部", Toast.LENGTH_SHORT).show();
                break;
            case R.id.view_left_hand:
                bodyPart = "hand";
                bodyImage = R.mipmap.ic_body_hand;
//                Toast.makeText(this, "左手", Toast.LENGTH_SHORT).show();
                break;
            case R.id.view_right_hand:
                bodyPart = "hand";
                bodyImage = R.mipmap.ic_body_hand;
//                Toast.makeText(this, "右手", Toast.LENGTH_SHORT).show();
                break;
            case R.id.view_left_arm:
                bodyPart = "arm";
                bodyImage = R.mipmap.ic_body_right_arm;
//                Toast.makeText(this, "左胳膊", Toast.LENGTH_SHORT).show();
                break;
            case R.id.view_right_arm:
                bodyPart = "arm";
                bodyImage = R.mipmap.ic_body_right_arm;
//                Toast.makeText(this, "右胳膊", Toast.LENGTH_SHORT).show();
                break;
            case R.id.view_chest:
                bodyPart = "chest";
                bodyImage = R.mipmap.ic_body_chest;
//                Toast.makeText(this, "胸部", Toast.LENGTH_SHORT).show();
                break;
            case R.id.view_abdomen:
                bodyPart = "abdomen";
                bodyImage = R.mipmap.ic_body_fubu;
//                Toast.makeText(this, "腹部", Toast.LENGTH_SHORT).show();
                break;
            case R.id.view_left_leg:
                bodyPart = "leg";
                bodyImage = R.mipmap.ic_body_leg;
//                Toast.makeText(this, "左腿", Toast.LENGTH_SHORT).show();
                break;
            case R.id.view_right_leg:
                bodyPart = "leg";
                bodyImage = R.mipmap.ic_body_leg;
//                Toast.makeText(this, "右腿", Toast.LENGTH_SHORT).show();
                break;
            case R.id.view_left_foot:
                bodyPart = "foot";
                bodyImage = R.mipmap.ic_body_foot;
//                Toast.makeText(this, "左脚", Toast.LENGTH_SHORT).show();
                break;
            case R.id.view_right_foot:
                bodyPart = "foot";
                bodyImage = R.mipmap.ic_body_foot;
//                Toast.makeText(this, "右脚", Toast.LENGTH_SHORT).show();
                break;
        }


        showView(bodyImage);
    }


    public void showView(final int bodyImage) {

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(bodyImage);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(params);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("body part")
                .setView(imageView)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intent = getIntent();
                        intent.putExtra("body", bodyPart);
                        intent.putExtra("bodyImage", bodyImage);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create().show();

    }

}
