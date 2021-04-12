package ro.pub.cs.systems.eim.colocviu1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Colocviu1_SecondaryActivity extends AppCompatActivity
{
    private Button register, cancel;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1__secondary);

        register = (Button)findViewById(R.id.button6);
        cancel = (Button)findViewById(R.id.button7);

        tv = (TextView)findViewById(R.id.textView);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToParent = new Intent();
                setResult(CONSTANTS.REGISTER_CODE, intentToParent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToParent = new Intent();
                setResult(CONSTANTS.CANCEL_CODE, intentToParent);
                finish();
            }
        });

        Intent intentFromParent = getIntent();

        Bundle extras = intentFromParent.getExtras();

        if (extras != null)
        {
            String value = String.valueOf(extras.getString(CONSTANTS.INSTRUCKTIONS_KEY));
            tv.setText(value);
        }
    }
}