package com.example.akshit.devclubassing3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int count=0;
    TextView t;
    Button b1;
    Button b2;
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t= (TextView) findViewById(R.id.clicks);
        b1= (Button) findViewById(R.id.button1);
        b2= (Button) findViewById(R.id.button2);
        b3= (Button) findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count ++;
                t.setText(Integer.toString(count));
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(count>0) {
                    count--;
                    t.setText(Integer.toString(count));
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                count=0;
                t.setText(Integer.toString(count));
            }
        });
    }
}
