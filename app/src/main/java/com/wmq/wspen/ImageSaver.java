package com.wmq.wspen;

import android.media.Image;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ImageSaver implements Runnable {
    private final Image mImage;
    private File mImageFile;
    private FileOutputStream mFileOutputStream;

    public ImageSaver(Image image) {
        mImage = image;
    }

    @Override
    public void run() {
        ByteBuffer buffer = mImage.getPlanes()[0].getBuffer();
        byte[] data = new byte[buffer.remaining()];
        buffer.get(data);
        String path = Environment.getExternalStorageDirectory() + "/DCIM/";

        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd");
        String fileName = String.format("%s_%05d.jpg", df.format(new Date()),1);
        File filePath = new File(String.format("%s%s", path, fileName));
//        if(!filePath.exists())
//            filePath.mkdirs();
        try {
            mFileOutputStream = new FileOutputStream(filePath);
            mFileOutputStream.write(data, 0, data.length);
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
        }
//        mImageFile = new File(Environment.getExternalStorageDirectory() + "/DCIM/myPicture.jpg");
//        try {
//            mImageFile.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(mImageFile);
//            fos.write(data, 0 ,data.length);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            mImageFile = null;
//            if (fos != null) {
//                try {
//                    fos.close();
//                    fos = null;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
