package com.example.myunitconverterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//Declaring widget icons
    EditText editText;
    TextView textView, textView2,textView4,valueInPounds;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialising the UI components
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView4 = findViewById(R.id.textView4);
         valueInPounds = findViewById(R.id.valueInPounds);
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFromKiloToPound();
            }
        });
    }

    private void convertFromKiloToPound() {
        String valueEnteredInKilo=editText.getText().toString().trim();
        if(valueEnteredInKilo.isEmpty()){
            Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }
        try{
            double kilo= Double.parseDouble(valueEnteredInKilo);
            double pounds= kilo * 2.205;
            valueInPounds.setText(""+pounds);
        }catch(NumberFormatException e){
            Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}