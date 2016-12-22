package com.zhang.drawable.layerleveldrawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.zhang.drawable.R;

public class TransitionDrawableActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView smile, multitrans;
    private TransitionDrawable transitionDrawable;
    private int[] ids = new int[]{R.mipmap.f20, R.mipmap.f21, R.mipmap.f23,
            R.mipmap.f24, R.mipmap.f25, R.mipmap.f26, R.mipmap.f27};
    private int change = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_drawable);

        smile = (ImageView) findViewById(R.id.smile);
        multitrans = (ImageView) findViewById(R.id.multitrans);
        transitionDrawable = (TransitionDrawable) smile.getDrawable();

        findViewById(R.id.go).setOnClickListener(this);
        findViewById(R.id.reversgo).setOnClickListener(this);
        findViewById(R.id.nextbtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go:
                transitionDrawable.startTransition(2000);
                break;
            case R.id.reversgo:
                transitionDrawable.reverseTransition(2000);
                break;
            case R.id.nextbtn:
                TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{
                        getResources().getDrawable(ids[change % ids.length], null),
                        getResources().getDrawable(ids[(change + 1) % ids.length], null)

                });
                change++;
                transitionDrawable.setCrossFadeEnabled(true);
                multitrans.setImageDrawable(transitionDrawable);
                transitionDrawable.startTransition(1000);
                break;

        }
    }
}
