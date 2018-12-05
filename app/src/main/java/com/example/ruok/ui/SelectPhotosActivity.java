package com.example.ruok.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.utils.ImageLoaderUtil;
import com.example.ruok.utils.SpUtil;

import java.util.List;

import classes.User;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;

public class SelectPhotosActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CODE_RECORD_PHOTO = 1;
    private static final int CODE_RECORD_FRONT = 2;
    private static final int CODE_RECORD_BACK = 3;
    private ImageView iv_record_photo;
    private TextView tv_record_photo;
    private ImageView iv_front;
    private ImageView iv_back;
    private String pathRecordPhoto, pathFrontPhoto, pathBackPhoto;
    private Button btn_confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_photos);
        initView();
    }

    private void initView() {
        iv_record_photo = (ImageView) findViewById(R.id.iv_record_photo);
        tv_record_photo = (TextView) findViewById(R.id.tv_record_photo);
        iv_front = (ImageView) findViewById(R.id.iv_front);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        btn_confirm = findViewById(R.id.btn_confirm);

        iv_record_photo.setOnClickListener(this);
        iv_front.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        btn_confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_record_photo:
                GalleryFinal.openGallerySingle(CODE_RECORD_PHOTO, mOnHanlderResultCallback);
                break;
            case R.id.iv_front:
                GalleryFinal.openGallerySingle(CODE_RECORD_FRONT, mOnHanlderResultCallback);
                break;
            case R.id.iv_back:
                GalleryFinal.openGallerySingle(CODE_RECORD_BACK, mOnHanlderResultCallback);
                break;
            case R.id.btn_confirm:
                Intent intent = getIntent();
                intent.putExtra("pathRecordPhoto", pathRecordPhoto);
                intent.putExtra("pathFrontPhoto", pathFrontPhoto);
                intent.putExtra("pathBackPhoto", pathBackPhoto);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }


    private GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback = new GalleryFinal.OnHanlderResultCallback() {
        @Override
        public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
            if (resultList != null) {
                final String photoPath = resultList.get(0).getPhotoPath();
                if (reqeustCode == CODE_RECORD_PHOTO) {
                    pathRecordPhoto = photoPath;
                    ImageLoaderUtil.display(SelectPhotosActivity.this, photoPath, iv_record_photo);
                } else if (reqeustCode == CODE_RECORD_FRONT) {
                    pathFrontPhoto = photoPath;
                    ImageLoaderUtil.display(SelectPhotosActivity.this, photoPath, iv_front);
                } else if (reqeustCode == CODE_RECORD_BACK) {
                    pathBackPhoto = photoPath;
                    ImageLoaderUtil.display(SelectPhotosActivity.this, photoPath, iv_back);
                }
            }
        }

        @Override
        public void onHanlderFailure(int requestCode, String errorMsg) {
            Toast.makeText(SelectPhotosActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
        }
    };

}
