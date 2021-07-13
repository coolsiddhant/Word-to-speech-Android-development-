package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToSpeech=new TextToSpeech(this,status -> {
            if(status!= TextToSpeech.ERROR){
                textToSpeech.setLanguage(Locale.UK);
            }
        } );

        findViewById(R.id.button1).setOnClickListener(v -> {
            textToSpeech.speak(((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
        });
    }
}