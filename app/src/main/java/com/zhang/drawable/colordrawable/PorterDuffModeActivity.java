package com.zhang.drawable.colordrawable;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.zhang.drawable.R;

public class PorterDuffModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porter_duff_mode);

        /** [Sa, Sc] */
        ((ImageView) findViewById(R.id.img1)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.SRC));

        /** [Da, Dc] */
        ((ImageView) findViewById(R.id.img2)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.DST));

        /** [Sa + (1 - Sa)*Da, Rc = Sc + (1 - Sa)*Dc] */
        ((ImageView) findViewById(R.id.img3)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.SRC_OVER));
        /** [Sa + (1 - Sa)*Da, Rc = Dc + (1 - Da)*Sc] */
        ((ImageView) findViewById(R.id.img4)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.DST_OVER));
        /** [Sa * Da, Sc * Da] */
        ((ImageView) findViewById(R.id.img5)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.SRC_IN));
        /** [Sa * Da, Sa * Dc] */
        ((ImageView) findViewById(R.id.img6)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.DST_IN));
        /** [Sa * (1 - Da), Sc * (1 - Da)] */
        ((ImageView) findViewById(R.id.img7)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.SRC_OUT));
        /** [Da * (1 - Sa), Dc * (1 - Sa)] */
        ((ImageView) findViewById(R.id.img8)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.DST_OUT));
        /** [Da, Sc * Da + (1 - Sa) * Dc] */
        ((ImageView) findViewById(R.id.img9)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.SRC_ATOP));
        /** [Sa, Sa * Dc + Sc * (1 - Da)] */
        ((ImageView) findViewById(R.id.img10)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.DST_ATOP));
        /** [Sa + Da - 2 * Sa * Da, Sc * (1 - Da) + (1 - Sa) * Dc] */
        ((ImageView) findViewById(R.id.img11)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.XOR));
        /** [Sa + Da - Sa*Da,
         Sc*(1 - Da) + Dc*(1 - Sa) + min(Sc, Dc)] */
        ((ImageView) findViewById(R.id.img12)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.DARKEN));
        /** [Sa + Da - Sa*Da,
         Sc*(1 - Da) + Dc*(1 - Sa) + max(Sc, Dc)] */
        ((ImageView) findViewById(R.id.img13)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.LIGHTEN));
        /** [Sa * Da, Sc * Dc] */
        ((ImageView) findViewById(R.id.img14)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.MULTIPLY));
        /** [Sa + Da - Sa * Da, Sc + Dc - Sc * Dc] */
        ((ImageView) findViewById(R.id.img15)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.SCREEN));
        /** Saturate(S + D) */
        ((ImageView) findViewById(R.id.img16)).getDrawable().mutate().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.ADD));
        ((ImageView) findViewById(R.id.img17)).getDrawable().
                setColorFilter(new PorterDuffColorFilter(0xff0000ff, PorterDuff.Mode.OVERLAY));
    }
}
