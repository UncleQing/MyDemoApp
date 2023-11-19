package com.zidian.mydemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class InfoActivity extends AppCompatActivity {
    public static InfoActivity sInfoActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sInfoActivity = this;
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();

////        layoutParams.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//        layoutParams.flags |= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
//        layoutParams.width = -1;
//        layoutParams.height = 200;
//        layoutParams.x = 0;
//        layoutParams.y = 0;
//        layoutParams.gravity = Gravity.START | Gravity.TOP;
//        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION;
//        layoutParams.format = PixelFormat.TRANSPARENT;

        window.setAttributes(layoutParams);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public static void close() {
        sInfoActivity.finish();
        sInfoActivity = null;
    }
}