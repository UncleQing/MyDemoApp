package com.zidian.mydemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;


public class LayerActivity extends AppCompatActivity {

    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layer);

        ViewStub viewStub = findViewById(R.id.vs_et_layer);
        Button btnEt = findViewById(R.id.btn_layer_et);
        Button btnInfo = findViewById(R.id.btn_layer_info);

        btnEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText == null) {
                    mEditText = (EditText) viewStub.inflate();
                }
                if (mEditText.getVisibility() == View.VISIBLE) {
                    mEditText.setVisibility(View.GONE);
                } else {
                    mEditText.setVisibility(View.VISIBLE);
                }
            }
        });
        Message message = Message.obtain();
        message.setAsynchronous(true);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InfoActivity.sInfoActivity == null) {
                    Intent intent = new Intent(LayerActivity.this, InfoActivity.class);
                    startActivity(intent);
                } else {
                    InfoActivity.close();
                }

//                if (ActivityUtils.getTopActivity() instanceof InfoActivity) {
//                    ActivityUtils.finishActivity(InfoActivity.class);
//                } else {
//                    ActivityUtils.startActivity(InfoActivity.class);
//                }

            }
        });

    }
}