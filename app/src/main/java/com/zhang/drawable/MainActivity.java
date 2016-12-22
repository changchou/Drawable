package com.zhang.drawable;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.PathShape;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.zhang.drawable.colordrawable.ColorFilterActivity;
import com.zhang.drawable.colordrawable.GradientTintActivity;
import com.zhang.drawable.drawable.CircleImageDrawable;
import com.zhang.drawable.drawable.RoundRectImageDrawable;
import com.zhang.drawable.drawable.ShaderFactoryActivity;
import com.zhang.drawable.layerleveldrawable.LayerDrawableActivity;
import com.zhang.drawable.layerleveldrawable.LevelDrawableActivity;
import com.zhang.drawable.layerleveldrawable.TransitionDrawableActivity;
import com.zhang.drawable.statelistdrawable.ColorStateListActivity;
import com.zhang.drawable.statelistdrawable.StateListDrawableActivity;

public class MainActivity extends AppCompatActivity {

    private ShapeDrawable shapeDrawable;
    private boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        ImageView img1 = (ImageView) findViewById(R.id.pic1);
        img1.setImageDrawable(new RoundRectImageDrawable(bitmap));

        ImageView img2 = (ImageView) findViewById(R.id.pic2);
        img2.setImageDrawable(new CircleImageDrawable(bitmap));

        final ImageView oval = (ImageView) findViewById(R.id.oval);
        oval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clicked) {
                    oval.setImageResource(R.drawable.oval2);
                    clicked = true;
                } else {
                    oval.setImageResource(R.drawable.oval);
                    clicked = false;
                }
            }
        });

        Path path = new Path();
        path.moveTo(50, 0);
        path.lineTo(0, 50);
        path.lineTo(50, 100);
        path.lineTo(100, 50);
        path.lineTo(50, 0);
        path.close();
        PathShape pathShape = new PathShape(path, 100, 100);
        shapeDrawable = new ShapeDrawable(pathShape);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.getPaint().setColor(Color.CYAN);
        findViewById(R.id.path).setBackground(shapeDrawable);

        ArcShape arcShape = new ArcShape(180, -270);
        shapeDrawable = new ShapeDrawable(arcShape);
        shapeDrawable.setBounds(0, 0, 100, 100);
        shapeDrawable.getPaint().setStrokeWidth(10);
        shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
        shapeDrawable.getPaint().setColor(Color.GREEN);
        findViewById(R.id.arc).setBackground(shapeDrawable);

        arcShape = new ArcShape(45, 270);
        shapeDrawable = new ShapeDrawable(arcShape);
        shapeDrawable.setBounds(0, 0, 200, 200);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.getPaint().setColor(Color.RED);
        findViewById(R.id.arc2).setBackground(shapeDrawable);
    }

    public void onClickToShaderFactory(View view) {
        startActivity(new Intent(this, ShaderFactoryActivity.class));
    }

    public void onClickToStateListDrawable(View view) {
        startActivity(new Intent(this, StateListDrawableActivity.class));
    }

    public void onClickToColorStateList(View view) {
        startActivity(new Intent(this, ColorStateListActivity.class));
    }

    public void onClickToColorFilter(View view) {
        startActivity(new Intent(this, ColorFilterActivity.class));
    }

    public void onClickToGradientTint(View view) {
        startActivity(new Intent(this, GradientTintActivity.class));
    }

    public void onClickToLayerDrawable(View view) {
        startActivity(new Intent(this, LayerDrawableActivity.class));
    }

    public void onClickToLevelDrawable(View view) {
        startActivity(new Intent(this, LevelDrawableActivity.class));
    }

    public void onClickToTransitionDrawable(View view) {
        startActivity(new Intent(this, TransitionDrawableActivity.class));
    }
}
