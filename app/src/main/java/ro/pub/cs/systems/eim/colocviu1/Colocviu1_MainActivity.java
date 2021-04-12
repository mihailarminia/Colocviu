package ro.pub.cs.systems.eim.colocviu1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Colocviu1_MainActivity extends AppCompatActivity
{
    private Button north, south, east, west, anotherActivity;
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
        anotherActivity = (Button)findViewById(R.id.button5);

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

        anotherActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String instructions = tv.getText().toString();
                Intent intentToChild = new Intent(Colocviu1_MainActivity.this, Colocviu1_SecondaryActivity.class);
                intentToChild.putExtra(CONSTANTS.INSTRUCKTIONS_KEY, instructions);
                startActivityForResult(intentToChild, CONSTANTS.MAIN_ACTIVITY_CODE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        switch(requestCode)
        {
            case CONSTANTS.MAIN_ACTIVITY_CODE:
            {
                if (resultCode == CONSTANTS.REGISTER_CODE)
                {
                    Toast.makeText(getApplicationContext(), "REGISTER CLICKED", Toast.LENGTH_SHORT).show();
                }
                else if (resultCode == CONSTANTS.CANCEL_CODE)
                {
                    Toast.makeText(getApplicationContext(), "CANCEL CLICKED", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            default:
                Log.d("TAG", "NIMIC");
        }
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