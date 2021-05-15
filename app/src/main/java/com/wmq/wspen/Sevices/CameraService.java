package com.wmq.wspen.Sevices;

import android.accessibilityservice.AccessibilityGestureEvent;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.samsung.android.sdk.penremote.ButtonEvent;
import com.samsung.android.sdk.penremote.SpenEvent;
import com.samsung.android.sdk.penremote.SpenEventListener;
import com.samsung.android.sdk.penremote.SpenRemote;
import com.samsung.android.sdk.penremote.SpenUnit;
import com.samsung.android.sdk.penremote.SpenUnitManager;

public  class  CameraService extends AccessibilityService
{
    protected static final String TAG = "tangtangAccessibilityService";
    @Override
    protected boolean onKeyEvent(KeyEvent event) {
        Log.d(TAG, "onKeyEvent " + event);
//        Toast.makeText(getApplicationContext(), "onKeyEvent " + event, Toast.LENGTH_LONG);
        return super.onKeyEvent(event);
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
        if(event.getPackageName().equals("com.samsung.android.service.aircommand"))
        {
            Log.d(TAG, "KEYCODE_onAccessibilityEvent" + event.toString());
            System.out.println("KEYCODE_onAccessibilityEvent" + event.toString());
//            Toast.makeText(getApplicationContext(), "onKeyEvent " + event, Toast.LENGTH_LONG);
        }
    }

    @Override
    public void onInterrupt() {

    }
}