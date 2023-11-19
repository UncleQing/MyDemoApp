package com.zidian.mydemoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.zidian.mydemoapp.R;

public class AudioDemoActivity extends AppCompatActivity {

    SoundPool mSoundPool;
    SoundPool mSoundPool2;
    SoundPool mSoundPool3;
    int soundId;
    int soundId2;
    int soundId3;

    AudioManager mAudioManager;
    AudioFocusRequest audioFocusRequest;

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {
            if (message.what == 1) {
                mAudioManager.abandonAudioFocusRequest(audioFocusRequest);
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_demo);

        findViewById(R.id.btn_test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSoundPool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        });

        findViewById(R.id.btn_test2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAudioManager.requestAudioFocus(audioFocusRequest);
                mHandler.sendEmptyMessageDelayed(1, 5000L);
                mSoundPool2.play(soundId2, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        });

        findViewById(R.id.btn_test3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSoundPool3.play(soundId3, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        });


        AudioAttributes mAudioAttributes1 = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build();

        AudioAttributes mAudioAttributes2 = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .build();

        AudioAttributes mAudioAttributes3 = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION_EVENT)
                .build();

        SoundPool.Builder spb = new SoundPool.Builder();
        spb.setMaxStreams(1);
        spb.setAudioAttributes(mAudioAttributes1);
        mSoundPool = spb.build();
        soundId = mSoundPool.load(this, R.raw.alarm, 1);

        SoundPool.Builder spb2 = new SoundPool.Builder();
        spb2.setMaxStreams(1);
        spb2.setAudioAttributes(mAudioAttributes2);
        mSoundPool2 = spb2.build();
        soundId2 = mSoundPool2.load(this, R.raw.alarm, 1);

        SoundPool.Builder spb3 = new SoundPool.Builder();
        spb3.setMaxStreams(1);
        spb3.setAudioAttributes(mAudioAttributes3);
        mSoundPool3 = spb3.build();
        soundId3 = mSoundPool3.load(this, R.raw.alarm, 1);


        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioFocusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                .setAudioAttributes(mAudioAttributes2)
                .setOnAudioFocusChangeListener(new AudioManager.OnAudioFocusChangeListener() {
                    @Override
                    public void onAudioFocusChange(int i) {
//                        public static final int AUDIOFOCUS_GAIN = 1;
//                        public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
//                        public static final int AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4;
//                        public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
//                        public static final int AUDIOFOCUS_LOSS = -1;
//                        public static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
//                        public static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;
//                        public static final int AUDIOFOCUS_NONE = 0;
//                        public static final int AUDIOFOCUS_REQUEST_DELAYED = 2;
//                        public static final int AUDIOFOCUS_REQUEST_FAILED = 0;
//                        public static final int AUDIOFOCUS_REQUEST_GRANTED = 1;
                        Log.d("BM", "onAudioFocusChange :" + i);
                    }
                }).build();
    }
}