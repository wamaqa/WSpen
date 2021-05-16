package com.wmq.wspen.Sevices;

import android.accessibilityservice.AccessibilityGestureEvent;
import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wmq.wspen.CameraSurfaceView;

import java.io.FileDescriptor;

public class CameraService extends Service {
    protected static final String TAG = "tangtangAccessibilityService";
    private CameraSurfaceView surfaceView;
    private static boolean mIsRun;
    private CameraBinder mBinder;

    public static boolean ismIsRun() {
        return mIsRun;
    }

    @SuppressLint("Range")
    @Override
    public void onCreate() {
        super.onCreate();
        mIsRun = true;
        mBinder = new CameraBinder(messenger);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mIsRun = false;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private Messenger messenger = new Messenger(new Handler() {

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case ConstParams.CameraPhotos: {
                    new CameraSurfaceView(getApplicationContext()).OpenCamera(true);
                }
                break;
            }
        }
    });
}

