package com.example.apple.internalstorage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 private EditText edit_text;
    private Button btn_save,btn_load;
    String text;
   private String filename = "mytext.text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_text = (EditText) findViewById(R.id.edit_text);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_load = (Button) findViewById(R.id.btn_load);
        btn_save.setOnClickListener(this);
        btn_load.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_save:
                text=edit_text.getText().toString();

                try {
                    FileOutputStream fOut = openFileOutput(filename, Context.MODE_PRIVATE);
                    fOut.write(text.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                }

                catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_load:
                try {
                    FileInputStream fis = openFileInput(filename);
                    int c;
                    String temp = " ";
                    while ((c = fis.read())!=-1){
                        temp = temp + Character.toString((char)c);
                    }
                    fis.close();
                    Toast.makeText(getBaseContext(),"file loaded",Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
        }

    }
}
