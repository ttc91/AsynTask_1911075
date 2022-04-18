package com.android.s1911075;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.s1911075.variable.Param;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textViewInfo;
    private Button buttonStart;
    private TextView textView1;

    private AsyncTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init(){

        this.progressBar = (ProgressBar) this.findViewById(R.id.pro);
        this.textViewInfo = (TextView) this.findViewById(R.id.tv_value);
        this.buttonStart = (Button) this.findViewById(R.id.btn_start);
        this.textView1= (TextView) this.findViewById(R.id.tv);

    }

    public void start(View view){

        this.task = new AsyncTask(this.progressBar, this.textViewInfo, this.buttonStart);
        Param param = new Param("Param 1", "Param 2");
        textView1.setText("Working...");
        this.task.execute(param);

    }
}