package com.zhang.drawable.colordrawable;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.zhang.drawable.R;

public class ColorFilterActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener {

    private TextView txt;
    private ImageView example;
    private SeekBar seekBar;
    private Drawable drawable, drawable1, drawable2;
    private float r = 1, g = 1, b = 1, a = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_filter);

        txt = (TextView) findViewById(R.id.txt);
        example = (ImageView) findViewById(R.id.example);

        drawable1 = txt.getBackground();
        drawable2 = example.getDrawable();
        drawable = drawable1;

        ((SeekBar) findViewById(R.id.seeka)).setOnSeekBarChangeListener(this);
        ((SeekBar) findViewById(R.id.seekr)).setOnSeekBarChangeListener(this);
        ((SeekBar) findViewById(R.id.seekg)).setOnSeekBarChangeListener(this);
        ((SeekBar) findViewById(R.id.seekb)).setOnSeekBarChangeListener(this);

        ((RadioGroup) findViewById(R.id.rgp)).setOnCheckedChangeListener(this);
        ((RadioGroup) findViewById(R.id.rgp1)).setOnCheckedChangeListener(this);
        ((RadioGroup) findViewById(R.id.rgp2)).setOnCheckedChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        float buf = (float) progress / 100;
        switch (seekBar.getId()) {
            case R.id.seeka:
                a = buf;
                break;
            case R.id.seekb:
                b = buf;
                break;
            case R.id.seekg:
                g = buf;
                break;
            case R.id.seekr:
                r = buf;
                break;
        }
        setArgb(a, r, g, b);
    }

    private void setArgb(float a, float r, float g, float b) {
        ColorMatrix mColorMatrix = new ColorMatrix(new float[]{
                r, 0, 0, 0, 0,
                0, g, 0, 0, 0,
                0, 0, b, 0, 0,
                0, 0, 0, a, 0,
        });
        drawable.setColorFilter(new ColorMatrixColorFilter(mColorMatrix));
        txt.postInvalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        ColorMatrix mColorMatrix;
        switch (checkedId) {
            case R.id.selecttxt:
                drawable = drawable1;
                break;
            case R.id.selectimage:
                drawable = drawable2;
                break;
            case R.id.light1:
                drawable.setColorFilter(new LightingColorFilter(0xf02f00, 0x0));
                break;
            case R.id.light2:
                drawable.setColorFilter(new LightingColorFilter(0x0000ff, 0x000088));
                break;
            case R.id.matrix1:
                mColorMatrix = new ColorMatrix(new float[]{
                        0, 1, 0, 0, 0,
                        0, 0, 1, 0, 0,
                        1, 0, 0, 0, 0,
                        0, 0, 0, 1, 0,
                });
                drawable.setColorFilter(new ColorMatrixColorFilter(mColorMatrix));
                break;
            case R.id.matrix2:
                mColorMatrix = new ColorMatrix(new float[]{
                        -1, 0, 0, 1, 0,
                        0, -1, 0, 1, 0,
                        0, 0, -1, 1, 0,
                        0, 0, 0, 1, 0,
                });
                drawable.setColorFilter(new ColorMatrixColorFilter(mColorMatrix));
                break;
        }
        txt.postInvalidate();
        example.postInvalidate();
    }

    public void onClickToPorterDuffMode(View view) {
        startActivity(new Intent(this, PorterDuffModeActivity.class));
    }
}
