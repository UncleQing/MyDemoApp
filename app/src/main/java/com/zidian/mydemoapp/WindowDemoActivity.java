package com.zidian.mydemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class WindowDemoActivity extends AppCompatActivity {

    WindowManager mWindowManager;
    WindowManager.LayoutParams mLayoutParams1;
    WindowManager.LayoutParams mLayoutParams2;
    WindowManager.LayoutParams mLayoutParams3;
    WindowManager.LayoutParams mLayoutParams4;

    View view1;
    View view2;
    View view3;
    View view4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window_demo);
        view1 = LayoutInflater.from(WindowDemoActivity.this).inflate(R.layout.layout_window_1, null, false);
        view2 = LayoutInflater.from(WindowDemoActivity.this).inflate(R.layout.layout_window_2, null, false);
        view3 = LayoutInflater.from(WindowDemoActivity.this).inflate(R.layout.layout_window_3, null, false);
        view4 = LayoutInflater.from(WindowDemoActivity.this).inflate(R.layout.layout_window_4, null, false);



        findViewById(R.id.btn_test_window).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view4.getVisibility() == View.GONE) {
                    view4.setVisibility(View.VISIBLE);
                } else {
                    view4.setVisibility(View.GONE);
                }
            }
        });
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WindowDemoActivity.this, "view1", Toast.LENGTH_SHORT).show();
            }
        });
        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WindowDemoActivity.this, "view4", Toast.LENGTH_SHORT).show();
            }
        });

        mWindowManager = getWindowManager();

        mLayoutParams1 = new WindowManager.LayoutParams();

        //TYPE_APPLICATION 这是普通的应用程序窗口类型，通常包含应用程序的主要用户界面。它们位于窗口层级的底部，是最常见的窗口类型
        //TYPE_APPLICATION_PANEL 与 TYPE_APPLICATION 类似，但允许窗口在某些情况下覆盖系统对话框，如键盘输入框。(可以覆盖系统状态栏)
        //TYPE_APPLICATION_ATTACHED_DIALOG：这是应用程序中附加对话框的窗口类型。它们通常位于 TYPE_APPLICATION 窗口的上方
        //TYPE_SYSTEM_ALERT：用于显示系统级别警告、通知和对话框的窗口类型。它们位于应用程序窗口的上方，以确保它们不会被应用程序内容遮挡。
        //TYPE_TOAST：用于显示短暂消息的窗口类型，通常会自动消失。它们位于应用程序窗口之上。
        //TYPE_PHONE：用于电话应用程序的窗口类型。它们通常位于所有其他窗口的上方，并且可以在来电时显示来电通知
        //TYPE_APPLICATION_OVERLAY：用于创建全局悬浮窗口的窗口类型，允许窗口在应用程序之外显示。这些窗口通常需要特殊权限(android.permission.SYSTEM_ALERT_WINDOW)
        //TYPE_SYSTEM_ERROR：用于显示系统错误和强制关闭对话框的窗口类型。它们位于所有其他窗口的顶部，并且通常不可取消。
        //TYPE_APPLICATION_MEDIA：用于媒体播放器的窗口类型，通常位于所有其他窗口的上方，以确保媒体播放器的控件可（显示不出来，比app还低看不到）
        //TYPE_APPLICATION_SUB_PANEL：所有面板上层
        mLayoutParams1.type = WindowManager.LayoutParams.TYPE_APPLICATION;

        mLayoutParams1.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        mLayoutParams1.flags |= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;


        mLayoutParams1.format = PixelFormat.TRANSLUCENT;
        mLayoutParams1.gravity = Gravity.START | Gravity.TOP;
        mLayoutParams1.width = 200;
        mLayoutParams1.height = 200;
        mLayoutParams1.x = 0;
        mLayoutParams1.y = 0;

        //2
        mLayoutParams2 = new WindowManager.LayoutParams();
        mLayoutParams2.type = WindowManager.LayoutParams.TYPE_APPLICATION;

        mLayoutParams2.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        mLayoutParams2.flags |= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;


        mLayoutParams2.format = PixelFormat.TRANSLUCENT;
        mLayoutParams2.gravity = Gravity.START | Gravity.TOP;
        mLayoutParams2.width = 200;
        mLayoutParams2.height = 200;
        mLayoutParams2.x = 150;
        mLayoutParams2.y = 0;

        //3
        mLayoutParams3 = new WindowManager.LayoutParams();
        mLayoutParams3.type = WindowManager.LayoutParams.TYPE_APPLICATION;

        mLayoutParams3.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        mLayoutParams3.flags |= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;


        mLayoutParams3.format = PixelFormat.TRANSLUCENT;
        mLayoutParams3.gravity = Gravity.START | Gravity.TOP;
        mLayoutParams3.width = 200;
        mLayoutParams3.height = 200;
        mLayoutParams3.x = 300;
        mLayoutParams3.y = 50;

        //4
        mLayoutParams4 = new WindowManager.LayoutParams();
        mLayoutParams4.type = WindowManager.LayoutParams.TYPE_APPLICATION;

        mLayoutParams4.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        mLayoutParams4.flags |= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;


        mLayoutParams4.format = PixelFormat.TRANSLUCENT;
        mLayoutParams4.gravity = Gravity.START | Gravity.TOP;
        mLayoutParams4.width = 200;
        mLayoutParams4.height = 200;
        mLayoutParams4.x = 0;
        mLayoutParams4.y = 50;

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                mWindowManager.addView(view1, mLayoutParams1);
                mWindowManager.addView(view2, mLayoutParams2);
                mWindowManager.addView(view3, mLayoutParams3);
                mWindowManager.addView(view4, mLayoutParams4);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}