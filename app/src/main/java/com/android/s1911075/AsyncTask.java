package com.android.s1911075;

import android.os.SystemClock;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.s1911075.variable.Param;
import com.android.s1911075.variable.Progress;
import com.android.s1911075.variable.Result;

import java.util.Date;

public class AsyncTask extends android.os.AsyncTask<Param, Progress, Result> {

    private ProgressBar progressBar;
    private TextView textView;
    private Button button;

    private final int PROGRESS_MAX;
    private int count = 0;
    private long startTimeInMillis;

    public AsyncTask(ProgressBar progressBar, TextView textView, Button button){

        this.progressBar = progressBar;
        this.textView = textView;
        this.button = button;
        this.PROGRESS_MAX = progressBar.getMax();
    }

    @Override
    protected Result doInBackground(Param... params) {

        final int WORK_MAX = 100;

        while (this.count < WORK_MAX) {
            SystemClock.sleep(572);
            this.count++;

            int progress = (this.count * PROGRESS_MAX) / WORK_MAX;
            int percent = (progress * 100) / PROGRESS_MAX;
            String value = "Sleeping in (" + percent +"%)";

            Progress pro = new Progress(progress, value);
            this.publishProgress(pro);
        }

        long finishTimeInMillis = new Date().getTime();
        long workTimeInMillis = finishTimeInMillis - this.startTimeInMillis;
        Result result = new Result(true, workTimeInMillis);
        return result;

    }

    @Override
    protected void onProgressUpdate(Progress... values) {
        super.onProgressUpdate(values);

        Progress pro= values[0];
        int progress = pro.getProgress();
        this.progressBar.setProgress(progress);
        this.textView.setText(pro.getWorkingInfo());

    }

    @Override
    protected void onPostExecute(Result result) {

        super.onPostExecute(result);
        this.button.setEnabled(true);
        this.textView.setText(result.getMessage());

    }

}
