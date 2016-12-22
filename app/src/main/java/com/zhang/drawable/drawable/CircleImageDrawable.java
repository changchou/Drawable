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

public class CircleImageDrawable extends Drawable {

    private Bitmap bitmap;
    private Paint paint;
    private int width;
    private RectF rectF;

    public CircleImageDrawable(Bitmap bitmap) {
        this.bitmap = bitmap;
        BitmapShader bitmapShader = new BitmapShader(bitmap,
                Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        rectF = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        width = Math.min(bitmap.getWidth(), bitmap.getHeight());
    }

    @Override
    public void setBounds(@NonNull Rect bounds) {
        super.setBounds(bounds);
        rectF = new RectF(bounds);
        width = (int) Math.min(rectF.width(), rectF.height());
    }

    @Override
    public int getIntrinsicWidth() {
        return width;
    }

    @Override
    public int getIntrinsicHeight() {
        return width;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawCircle(rectF.left + width / 2, rectF.top + width / 2, width / 2, paint);
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
