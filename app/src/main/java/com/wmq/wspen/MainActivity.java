package com.wmq.wspen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.wmq.wspen.Sevices.CameraService;

import java.util.Arrays;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
//    private CameraDevice mCameraDevice;
    private Switch mSwitchPhotos;
//    private String[] permission = {Manifest.permission.CAMERA};
//    private SurfaceHolder myHolder;
//    private TextureView mSurfaceView;
//    private static final SparseIntArray ORIENTATION = new SparseIntArray();
//
//    static {
//        ORIENTATION.append(Surface.ROTATION_0, 90);
//        ORIENTATION.append(Surface.ROTATION_90, 0);
//        ORIENTATION.append(Surface.ROTATION_180, 270);
//        ORIENTATION.append(Surface.ROTATION_270, 180);
//    }
//
//    private Size mPreviewSize;
//    private ImageReader mImageReader;
//    private Surface mSurface;
//    private CameraCaptureSession mCaptureSession;
//    private SurfaceTexture mSurfaceTexture;
//
//    private void setupImageReader() {
//        //?????????????????????????????????????????????????????????????????????????????????????????????????????????
//        mImageReader = ImageReader.newInstance(mPreviewSize.getWidth(), mPreviewSize.getHeight(), ImageFormat.JPEG, 1);
//        //??????ImageReader???????????????????????????????????????????????????onImageAvailable??????????????????????????????????????????????????????????????????????????????
//        mImageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
//            @Override
//            public void onImageAvailable(ImageReader reader) {
//                Image image = reader.acquireLatestImage();
//                // ??????????????????????????????
//                new Thread(new ImageSaver(image)).start();
//            }
//        }, null);
//    }
//
//    private CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
//
//        @Override
//        public void onOpened(@NonNull CameraDevice camera) {
//            mCameraDevice = camera;
//            StartPreView();
//
//        }
//
//        @Override
//        public void onDisconnected(@NonNull CameraDevice camera) {
//
//        }
//
//        @Override
//        public void onError(@NonNull CameraDevice camera, int error) {
//
//        }
//    };
//
//
//    private void StartPreView() {
//        setupImageReader();
//        SurfaceTexture surfaceTexture = mSurfaceView.getSurfaceTexture();
//        mSurface = new Surface(surfaceTexture);
//        try {
//            mCameraDevice.createCaptureSession(Arrays.asList(mSurface, mImageReader.getSurface()), new CameraCaptureSession.StateCallback() {
//                @Override
//                public void onConfigured(@NonNull CameraCaptureSession session) {
//                    mCaptureSession = session;
//                    CaptureRequest.Builder builder = null;
//                    try {
//                        builder = mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
//                        builder.addTarget(mSurface);
//                        builder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AF_MODE_AUTO);
//                        CaptureRequest captureRequest = builder.build();
//                        mCaptureSession.setRepeatingRequest(captureRequest, mPreviewCaptureCallback, null);
//                    } catch (CameraAccessException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//                @Override
//                public void onConfigureFailed(@NonNull CameraCaptureSession session) {
//
//                }
//            }, null);
//
//        } catch (CameraAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private String mCameraId;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
//            OpenCamera();
            CameraSurfaceView cameraSurfaceView = new CameraSurfaceView(this.getApplicationContext());
            cameraSurfaceView.OpenCamera(true);
        }
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
//            capture();
        }
        return super.onKeyDown(keyCode, event);
    }
//    private void OpenCamera() {
//        CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
//        try {
//            for (String cameraId : manager.getCameraIdList()) {
//                CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraId);
//                //???????????????????????????
//                if (characteristics.get(CameraCharacteristics.LENS_FACING) == CameraCharacteristics.LENS_FACING_FRONT)
//                    continue;
//                StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
//                mPreviewSize = map.getOutputSizes(SurfaceTexture.class)[0];
//                mCameraId = cameraId;
//                break;
//            }
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                requestPermissions(new String[]{Manifest.permission.CAMERA}, 10);
//            }
//            manager.openCamera(mCameraId, stateCallback, null);
//
//
//        } catch (CameraAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private CameraCaptureSession.CaptureCallback mPreviewCaptureCallback = new CameraCaptureSession.CaptureCallback() {
//        @Override
//        public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result) {
//
//        }
//
//        @Override
//        public void onCaptureProgressed(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull CaptureResult partialResult) {
//
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //????????????
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 10);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 10);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SYSTEM_ALERT_WINDOW) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.SYSTEM_ALERT_WINDOW}, 10);
        }
//        mSurfaceView = findViewById(R.id.camera_surfaceview1);
//        mSurfaceView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
//            @Override
//            public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
//                mSurfaceTexture = surface;
//            }
//
//            @Override
//            public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {
//
//            }
//
//            @Override
//            public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
//                return false;
//            }
//
//            @Override
//            public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {
//
//            }
//        });
        mSwitchPhotos = this.findViewById(R.id.switch_takePhotos);
        mSwitchPhotos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    startService(new Intent(getBaseContext(), CameraService.class));
                } else
                    stopService(new Intent(getBaseContext(), CameraService.class));
            }
        });


    }

//    private void capture() {
//        try {
//            //?????????????????????????????????CaptureRequest
//            final CaptureRequest.Builder mCaptureBuilder = mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
//            //??????????????????
//            int rotation = getWindowManager().getDefaultDisplay().getRotation();
//
//            mCaptureBuilder.addTarget(mSurface);
//            mCaptureBuilder.addTarget(mImageReader.getSurface());
//            mCaptureBuilder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AF_MODE_AUTO);
//            //??????????????????
//            mCaptureBuilder.set(CaptureRequest.JPEG_ORIENTATION, ORIENTATION.get(rotation));
//
//            //???????????????????????????????????????????????????????????????mCaptureBuilder??????ImageReader??????target????????????????????????ImageReader???onImageAvailable()??????????????????
//            CameraCaptureSession.CaptureCallback captureCallback = new CameraCaptureSession.CaptureCallback() {
//
//                @Override
//                public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result) {
//                }
//            };
//
//            mCaptureSession.capture(mCaptureBuilder.build(), captureCallback, null);
//        } catch (CameraAccessException e) {
//            e.printStackTrace();
//        }
//    }
}