package com.wmq.wspen.Sevices;

import android.accessibilityservice.AccessibilityGestureEvent;
import android.accessibilityservice.AccessibilityService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;

import androidx.annotation.NonNull;

public class AppAccessibiliyService extends AccessibilityService {

    protected static final String TAG = "AppAccessibiliyService";
    private CameraBinder mBinder;
    private KeyEvent mKeyEvent;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBinder = (CameraBinder) service;
            try {
                PostMessage(mKeyEvent);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    protected boolean onKeyEvent(KeyEvent event) {
        mKeyEvent = event;
        if(CameraService.ismIsRun())
        {
            try {
                if(mBinder== null)
                {
                    Intent intent = new Intent(this.getApplicationContext(), CameraService.class);
                    getApplicationContext().bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
                }
                else
                {
                    PostMessage(event);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onKeyEvent(event);
    }

    private void PostMessage(KeyEvent event) throws RemoteException {
        if(event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_UP && event.getAction() == 0)
        {
            Message message = Message.obtain(null, ConstParams.CameraPhotos, 00,0);
            message.replyTo = messenger;
            Bundle bundle = new Bundle();
            bundle.putInt("KeyCode", event.getKeyCode());
            message.setData(bundle);
            mBinder.getMessenger().send(message);
        }
    }

    @Override
    public void onInterrupt() {

    }
    @Override
    public void onSystemActionsChanged() {
        super.onSystemActionsChanged();
    }

    @Override
    public boolean onGesture(@NonNull AccessibilityGestureEvent gestureEvent) {
        System.out.println("KEYCODE_gestureEvent" + gestureEvent.toString());
        return super.onGesture(gestureEvent);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        try {
            if (event.getPackageName().equals("com.samsung.android.service.aircommand")) {
                Log.d(TAG, "KEYCODE_onAccessibilityEvent" + event.toString());
                System.out.println("KEYCODE_onAccessibilityEvent" + event.toString());
            }
        }catch (Exception e)
        {

        }
    }
    private Messenger messenger = new Messenger(new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    });
}

