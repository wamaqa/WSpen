package com.wmq.wspen.Sevices;

import android.os.Binder;
import android.os.Messenger;

public class CameraBinder extends Binder {
    public Messenger getMessenger() {
        return mMessenger;
    }

    private final Messenger mMessenger;

    public CameraBinder(Messenger messenger) {
        mMessenger = messenger;
    }
}
