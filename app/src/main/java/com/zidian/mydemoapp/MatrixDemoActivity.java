package com.zidian.mydemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.zidian.mydemoapp.widget.MatrixDrawView;

import timber.log.Timber;

//https://www.jianshu.com/p/5e30db034596
public class MatrixDemoActivity extends AppCompatActivity {

    private Matrix mMatrix;
    private MatrixDrawView ivMain;
    private float translateX;
    private float translateY;
    private int rotate;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float skewX;
    private float skewY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_demo_acitivy);

        initView();

        mMatrix = new Matrix();
    }

    private void initView() {
        SeekBar sbX = findViewById(R.id.sb_translate_x);
        SeekBar sbY = findViewById(R.id.sb_translate_y);
        SeekBar sbRotate = findViewById(R.id.sb_rotate_x);
        SeekBar sbSX = findViewById(R.id.sb_scale_x);
        SeekBar sbSY = findViewById(R.id.sb_scale_y);
        SeekBar sbSkX = findViewById(R.id.sb_skew_x);
        SeekBar sbSkY = findViewById(R.id.sb_skew_y);

        TextView sbTvX = findViewById(R.id.tv_progress_sb_translate_x);
        TextView sbTvY = findViewById(R.id.tv_progress_sb_translate_y);
        TextView sbTvRX = findViewById(R.id.tv_progress_sb_rotate_x);
        TextView sbTvSX = findViewById(R.id.tv_progress_sb_scale_x);
        TextView sbTvSY = findViewById(R.id.tv_progress_sb_scale_y);
        TextView sbTvSkX = findViewById(R.id.tv_progress_sb_skew_x);
        TextView sbTvSkY = findViewById(R.id.tv_progress_sb_skew_y);

        ivMain = findViewById(R.id.iv_matrix_main);

        sbX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) return;
                sbTvX.setText(progress * 100 + "/1000");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int p = seekBar.getProgress();
                translateX = p * 100;
                dealMatrixBoth();
            }
        });
        sbY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) return;
                sbTvY.setText(progress * 100 + "/1000");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int p = seekBar.getProgress();
                translateY = p * 100;
                dealMatrixBoth();
            }
        });
        sbRotate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) return;
                sbTvRX.setText(progress * 30 + "/360");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int p = seekBar.getProgress();
                rotate = p * 30;
                dealMatrixBoth();
            }
        });
        sbSX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) return;
                sbTvSX.setText(progress * 2.0f / 10 + "f/2.0f");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int p = seekBar.getProgress();
                scaleX = p * 2.0f / 10;
                dealMatrixBoth();
            }
        });
        sbSY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) return;
                sbTvSY.setText(progress * 2.0f / 10 + "f/2.0f");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int p = seekBar.getProgress();
                scaleY = p * 2.0f / 10;
                dealMatrixBoth();
            }
        });
        sbSkX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) return;
                sbTvSkX.setText(progress * 1.0f / 10 + "f/1.0f");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int p = seekBar.getProgress();
                skewX = p * 1.0f / 10;
                dealMatrixBoth();
            }
        });
        sbSkY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) return;
                sbTvSkY.setText(progress * 1.0f / 10 + "f/1.0f");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int p = seekBar.getProgress();
                skewY = p * 1.0f / 10;
                dealMatrixBoth();
            }
        });
    }

    private void dealMatrixBoth() {
        Timber.e("translateX : %s, translateY : %s", translateX, translateY);
        Timber.e("rotateX : %s", rotate);
        Timber.e("scaleX : %s, scaleY : %s", scaleX, scaleY);
        Timber.e("skewX : %s, skewY : %s", skewX, skewY);
        mMatrix.setScale(scaleX, scaleY);

        mMatrix.postTranslate(translateX, translateY);

        int cx = (int) translateX + (int)(ivMain.getBitMapWidth() * scaleX / 2);
        int cy = (int) translateY + (int)(ivMain.getBitMapHeight() * scaleY / 2);
        mMatrix.postRotate(rotate, cx, cy);

        mMatrix.preSkew(skewX, skewY);

        ivMain.setMatrix(mMatrix);
    }
}