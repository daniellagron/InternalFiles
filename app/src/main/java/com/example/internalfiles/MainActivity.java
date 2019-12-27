package com.example.internalfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText et;
    String text, st;
    String line;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);


        FileInputStream fis = null;
        try {
            fis = openFileInput("test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer();
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
            sb.append(line + " ");
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        st = sb.toString();
        try {
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tv.setText(tv.getText().toString() + st);


    }




    public void save(View view) {
        text = et.getText().toString();
        FileOutputStream fos;
        {
            try {
                fos = openFileOutput("test.txt", MODE_PRIVATE);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(text);
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream fis = null;
        try {
            fis = openFileInput("test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer();
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
            sb.append(line + " ");
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        st = sb.toString();
        try {
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv.setText(tv.getText().toString() + st);
    }





    public void reset(View view) {
        FileOutputStream fos;
        {
            try {
                fos = openFileOutput("test.txt", MODE_PRIVATE);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write("");
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        tv.setText("");
    }





    public void exit(View view) {
        text = tv.getText().toString();
        FileOutputStream fos;
        {
            try {
                fos = openFileOutput("test.txt", MODE_PRIVATE);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(text);
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        finish();
    }



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
            Intent si = new Intent(this,Credits.class);
            startActivity(si);
        return true;
    }


}
