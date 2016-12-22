package com.zhang.drawable.statelistdrawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.zhang.drawable.R;

public class ColorStateListActivity extends AppCompatActivity {

    private ListView lstv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_state_list);

        lstv=(ListView)findViewById(R.id.lstv);
        lstv.setAdapter(new Adapter());
        lstv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


    public class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(), R.layout.item, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.checkBox.setChecked(true);

            return convertView;
        }

        class ViewHolder {
            Button button;
            CheckBox checkBox;

            public ViewHolder(View v) {
                button = (Button) v.findViewById(R.id.button);
                checkBox = (CheckBox) v.findViewById(R.id.checkbox);
            }
        }
    }
}
