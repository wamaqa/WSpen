package com.wmq.wspen;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.media.Image;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageSaver implements Runnable {
//    private final Image mImage;
    private  byte[] mByteBuffer;
    public CameraDevice mCameraDevice;
    public CameraCaptureSession mCaptureSession;
    public Runnable Close;
    private File mImageFile;
    private FileOutputStream mFileOutputStream;

    public ImageSaver( byte[] byteBuffer) {
        mByteBuffer = byteBuffer;
    }

    @Override
    public void run() {

        String path = Environment.getExternalStorageDirectory() + "/DCIM/";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmssSSS");
        Date now = new Date();
        String fileName = String.format("%s_%s.jpg", dateFormat.format(now),timeFormat.format(now));
        File filePath = new File(String.format("%s%s", path, fileName));
//        if(!filePath.exists())
//            filePath.mkdirs();
        try {
            mFileOutputStream = new FileOutputStream(filePath);
            mFileOutputStream.write(mByteBuffer, 0, mByteBuffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (mFileOutputStream != null) {
                try {
                    mFileOutputStream.close();
                    mFileOutputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(Close!=null)
                Close.run();
        }
    }
}
