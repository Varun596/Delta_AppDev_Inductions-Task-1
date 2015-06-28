package com.example.varunelango.counter;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Counter extends ActionBarActivity{
    Button button;
    TextView tv;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        button=(Button)findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView);

        SharedPreferences prefs = getSharedPreferences("store",MODE_PRIVATE);
        String StoredValue = prefs.getString("LastValue","FirstTime");
        counter= Integer.parseInt(StoredValue);
        tv.setText("" + counter);

        button.setOnClickListener(
        new Button.OnClickListener(){
            public void onClick (View v)
            {
                counter++;
                tv.setText("" + counter);
                storeToSharedPreferences();
            }
        }
        );
    }

    public void storeToSharedPreferences(){
        SharedPreferences prefs = getSharedPreferences("store",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("LastValue", String.valueOf(counter));
        editor.commit();
    }

}
