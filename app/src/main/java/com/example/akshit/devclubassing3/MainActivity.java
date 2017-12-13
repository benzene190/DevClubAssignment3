package com.example.akshit.devclubassing3;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {
    private int count=0, step=1;
    TextView t;
    Button b1;
    Button b2;
    Button b3;
    private static TextView tv;
    static Dialog d;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView1);
        Button b = (Button) findViewById(R.id.button11);
        b.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                show();
            }
        });



        t= (TextView) findViewById(R.id.clicks);
        b1= (Button) findViewById(R.id.button1);
        b2= (Button) findViewById(R.id.button2);
        b3= (Button) findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count+=step;
                t.setText(Integer.toString(count));
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(count>0) {
                    count-=step;
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

    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

        Log.i("value is","Step="+newVal);

    }
    public void show()
    {

        final Dialog d = new Dialog(MainActivity.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.dialog);
        Button b1 = (Button) d.findViewById(R.id.buttonp);
        Button b2 = (Button) d.findViewById(R.id.buttonq);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(100);
        np.setMinValue(1);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(this);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                tv.setText("Step="+String.valueOf(np.getValue()));
                step=np.getValue();
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();


    }
}
