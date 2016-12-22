package com.zhang.drawable.layerleveldrawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.zhang.drawable.R;

public class LevelDrawableActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ImageView example,shapelevel,shapelevel1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_drawable);

        example=(ImageView)findViewById(R.id.example);
        shapelevel=(ImageView)findViewById(R.id.shapelevel);
        shapelevel1=(ImageView)findViewById(R.id.shapelevel1);
        ((SeekBar) findViewById(R.id.seekbar)).setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        example.setImageLevel(progress);
        shapelevel.setImageLevel(progress);
        shapelevel1.setImageLevel(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
