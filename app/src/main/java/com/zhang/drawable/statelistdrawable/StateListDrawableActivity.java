package com.zhang.drawable.statelistdrawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.zhang.drawable.R;

public class StateListDrawableActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private TextView txt;
    private CheckBox checkbox;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_list_drawable);

        txt = (TextView) this.findViewById(R.id.txt);
        edit = (EditText) this.findViewById(R.id.edit);
        checkbox = (CheckBox) this.findViewById(R.id.checkbox);

        ((CheckBox) findViewById(R.id.enabled)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.selected)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.focused)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.activated)).setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.enabled:
                txt.setEnabled(isChecked);
                break;
            case R.id.selected:
                txt.setSelected(isChecked);
                break;
            case R.id.focused:
                if (isChecked) {
                    edit.requestFocus();
                } else {
                    edit.clearFocus();
                }
                break;
            case R.id.activated:
                txt.setActivated(isChecked);
                break;

        }
    }
}
