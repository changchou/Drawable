package com.zhang.drawable.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

/**
 * Created by Mr.Z on 2016/11/30 0030.
 */

public class RoundRectImageDrawable extends Drawable {

    private Bitmap bitmap;
    private Paint paint;
    private RectF rectF;

    public RoundRectImageDrawable(Bitmap bitmap) {
        this.bitmap = bitmap;
        //着色器
        BitmapShader bitmapShader = new BitmapShader(bitmap,
                Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        rectF = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

//    @Override
//    public void setBounds(int left, int top, int right, int bottom) {
//        super.setBounds(left, top, right, bottom);
//        rectF = new RectF(left, top, right, bottom);
//    }

    @Override
    public void setBounds(@NonNull Rect bounds) {
        super.setBounds(bounds);
        rectF = new RectF(bounds);
    }

    @Override
    public int getIntrinsicWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getIntrinsicHeight() {
        return bitmap.getHeight();
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawRoundRect(rectF, 30, 30, paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
