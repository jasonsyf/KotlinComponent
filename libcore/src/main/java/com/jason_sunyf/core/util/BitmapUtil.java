package com.jason_sunyf.core.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017/11/23.
 */

public class BitmapUtil {
    private static String sdState = Environment.getExternalStorageState();
    private static String path = Environment.getExternalStorageDirectory()
            .toString();
    public static final String PHTOT_NAME = "/PHOTO";

    /**
     * 把图片保存到sd卡中，保存的路径为storage/PHOTO;
     *
     * @param bitmap
     * @param imageName
     */
    public static void saveBitmap(Bitmap bitmap, String imageName) {
        File file;
        File PicName;
        if (sdState.equals(Environment.MEDIA_MOUNTED)) {
            // 获得sd卡根目录
            file = new File(path + PHTOT_NAME);
            if (!file.exists()) {
                file.mkdirs();
            }
            PicName = new File(file, imageName);
            try {
                if (!PicName.exists()) {
                    PicName.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(PicName);
                if (PicName.getName().endsWith(".png")) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 70, fos);
                } else if (PicName.getName().endsWith(".jpg")) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 70, fos);
                }
                fos.flush();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从sd卡中取出图片；
     *
     * @param imageName
     * @return
     */
    public static Bitmap getBitmap(String imageName) {
        Bitmap bitmap = null;
        File imagePic;
        if (sdState.equals(Environment.MEDIA_MOUNTED)) {

            imagePic = new File(path + PHTOT_NAME, imageName);
            if (imagePic.exists()) {
                try {
                    bitmap = BitmapFactory.decodeStream(new FileInputStream(
                            imagePic));
                } catch (FileNotFoundException e) {
                    // e.printStackTrace();
                }
            }
        }
        return bitmap;
    }

    /**
     * 删除sd卡上的图片；
     *
     * @param file
     */
    public static void deleteFile(File file) {
        if (sdState.equals(Environment.MEDIA_MOUNTED)) {
            if (file.exists()) {
                if (file.isFile()) {
                    file.delete();
                }
                // 如果它是一个目录
                else if (file.isDirectory()) {
                    // 声明目录下所有的文件 files[];
                    File files[] = file.listFiles();
                    for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
                        deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
                    }
                }
                file.delete();
            }
        }
    }

    /**
     * 把文本保存到SDCard/Android/data/你的应用的包名/files/ 目录下，当卸载应用的时候删除；
     *
     * @param context
     * @param fileName
     * @param text
     */
    public static void savetoSDText(Context context, String fileName,
                                    String text) {
        // TODO Auto-generated method stub
        File file = context.getExternalFilesDir("/photo");
        try {
            FileOutputStream fos = new FileOutputStream(file + "/" + fileName);
            fos.write(text.getBytes());
            fos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 把图片保存SDCard/Android/data/你的应用的包名/files/ 目录下 当卸载应用的时候删除
     *
     * @param context
     * @param fileName
     * @param bitmap
     */
    public static void saveToSDBitmap(Context context, String fileName,
                                      Bitmap bitmap) {
        File file = context.getExternalFilesDir("/photo");
        try {
            FileOutputStream fos = new FileOutputStream(file + "/" + fileName);
            bitmap.compress(Bitmap.CompressFormat.PNG, 75, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    /**
     * 得到圆角图片； bitmap:传入图片 roundPx :传入显示的圆角弧度，一般设置10.0就可以
     */
    private static Bitmap output;

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {
        if (bitmap != null) {
            output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
                    Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);
            final int color = 0xff424242;
            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, bitmap.getWidth(),
                    bitmap.getHeight());
            final RectF rectF = new RectF(rect);

            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(color);
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
        }
        return output;
    }
    /**
     * 得到圆形图片；
     */
    public static Bitmap toRoundBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float roundPx;
        float left,top,right,bottom,dst_left,dst_top,dst_right,dst_bottom;
        if (width <= height) {
            roundPx = width / 2;
            top = 0;
            bottom = width;
            left = 0;
            right = width;
            height = width;
            dst_left = 0;
            dst_top = 0;
            dst_right = width;
            dst_bottom = width;
        } else {
            roundPx = height / 2;
            float clip = (width - height) / 2;
            left = clip;
            right = width - clip;
            top = 0;
            bottom = height;
            width = height;
            dst_left = 0;
            dst_top = 0;
            dst_right = height;
            dst_bottom = height;
        }

        Bitmap output = Bitmap.createBitmap(width,
                height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect src = new Rect((int)left, (int)top, (int)right, (int)bottom);
        final Rect dst = new Rect((int)dst_left, (int)dst_top, (int)dst_right, (int)dst_bottom);
        final RectF rectF = new RectF(dst);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, src, dst, paint);
        return output;
    }
    /**
     *
     * 判断sd卡是否可用；
     *
     * @return
     */
    public static boolean isSdcardExisting() {
        final String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
}
