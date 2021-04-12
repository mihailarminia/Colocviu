package ro.pub.cs.systems.eim.colocviu1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Colocviu1_MainActivity extends AppCompatActivity
{
    private Button north, south, east, west;
    private TextView tv;
    private int noOfClicks;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        north = (Button)findViewById(R.id.button);
        south = (Button)findViewById(R.id.button2);
        east = (Button)findViewById(R.id.button3);
        west = (Button)findViewById(R.id.button4);

        tv = (TextView)findViewById(R.id.text1);
        tv.setText("");

        noOfClicks = 0;

        north.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = tv.getText().toString();
                if (value.isEmpty())
                {
                    value = value + "North";
                }
                else
                {
                    value = value + ", North";
                }

                tv.setText(value);
                noOfClicks++;
            }
        });

        south.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = tv.getText().toString();
                if (value.isEmpty())
                {
                    value = value + "South";
                }
                else
                {
                    value = value + ", South";
                }

                tv.setText(value);
                noOfClicks++;
            }
        });

        east.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = tv.getText().toString();
                if (value.isEmpty())
                {
                    value = value + "East";
                }
                else
                {
                    value = value + ", East";
                }

                tv.setText(value);
                noOfClicks++;
            }
        });

        west.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = tv.getText().toString();
                if (value.isEmpty())
                {
                    value = value + "West";
                }
                else
                {
                    value = value + ", West";
                }

                tv.setText(value);
                noOfClicks++;
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.d("TAG", "onSaveInstanceState");

        savedInstanceState.putInt("NOOFCLICKS", noOfClicks);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("TAG", "onRestoreInstanceState");

        if (savedInstanceState.containsKey("NOOFCLICKS"))
        {
            noOfClicks = savedInstanceState.getInt("NOOFCLICKS");
            Log.d("TAG", noOfClicks + "");
        }
    }
}