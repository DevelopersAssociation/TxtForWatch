package com.fruitbasket.txtforwatch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    private static final String TAG=".MainActivity";

    private EditText inputET;
    private Button totalB;
    private Button clearB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        MyClickListener listener=new MyClickListener();

        inputET=(EditText)findViewById(R.id.input_et);

        totalB =(Button)findViewById(R.id.total_b);
        totalB.setOnClickListener(listener);

        clearB=(Button)findViewById(R.id.clear_b);
        clearB.setOnClickListener(listener);
    }

    private class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.total_b:
                    total();
                    break;

                case R.id.clear_b:
                    clear();
                    break;

                default:
            }
        }

        private void total(){
            int total=inputET.getText().toString().trim().split(" ").length;
            Toast.makeText(MainActivity.this,"total is "+total,Toast.LENGTH_SHORT).show();
        }

        private void clear(){
            inputET.setText("");
        }
    }
}
