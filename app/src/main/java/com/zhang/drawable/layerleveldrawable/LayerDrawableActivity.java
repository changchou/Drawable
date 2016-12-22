package com.zhang.drawable.layerleveldrawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.zhang.drawable.R;

public class LayerDrawableActivity extends AppCompatActivity {

    private Drawable eye1, eye2;
    private LayerDrawable layerDrawable;
    private ImageView catshow;
    private boolean eyeopen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layer_drawable);

        catshow = (ImageView) findViewById(R.id.catshow);
        layerDrawable = (LayerDrawable) catshow.getDrawable();
        eye1 = layerDrawable.findDrawableByLayerId(R.id.eye1);
        eye2 = layerDrawable.findDrawableByLayerId(R.id.eye2);

        //   eye2.setVisible(false,true);
        findViewById(R.id.cateyechange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                eye1.setAlpha(0x0);
                //  eye2.setVisible(true,false);
                if (eyeopen) {
                    eye1.setAlpha(0x0);
                    eye2.setAlpha(0xff);

                } else {
                    eye1.setAlpha(0xff);
                    eye2.setAlpha(0x0);
                }
                eyeopen = !eyeopen;
            }
        });

        Drawable[] drawables = new Drawable[3];

        drawables[0] = getResources().getDrawable(R.drawable.shape2, null);
        drawables[1] = getResources().getDrawable(R.drawable.shape2, null);
        drawables[2] = getResources().getDrawable(R.drawable.shape2, null);
        layerDrawable = new LayerDrawable(drawables);
        layerDrawable.setLayerInset(0, 20, 20, 0, 0);
        layerDrawable.setLayerInset(1, 40, 40, 0, 0);
        layerDrawable.setLayerInset(2, 60, 60, 0, 0);
        ImageView imageView = (ImageView) findViewById(R.id.img3);
        imageView.setImageDrawable(layerDrawable);
    }
}
