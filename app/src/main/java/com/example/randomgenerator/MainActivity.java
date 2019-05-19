package com.example.randomgenerator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1= findViewById(R.id.editText1);
        editText2= findViewById(R.id.editText2);
        textView= findViewById(R.id.textView);
        editText1.setFilters(new InputFilter[]{ new MinMaxFilter("0", "2147483647")});
        editText2.setFilters(new InputFilter[]{ new MinMaxFilter("0", "2147483647")});
        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(editText1.length() == 0){
                        editText1.setText("0");
                    }
                }
            }
        });
        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(editText2.length() == 0){
                        editText2.setText("0");
                    }
                }
            }
        });
    }

    public void onClickGenera(View v){
        int ris;
        int min=Integer.parseInt(editText1.getText().toString());
        int max=Integer.parseInt(editText2.getText().toString());
        if(min<=max){
            ris=RandInt.randInt(min, max);
        }
        else{
            ris=RandInt.randInt(max, min);
        }
        SpannableString s= new SpannableString("Numero generato: " + ris);
        s.setSpan(new ForegroundColorSpan(Color.RED),16, s.length(), 0);
        textView.setText(s);
    }
}
