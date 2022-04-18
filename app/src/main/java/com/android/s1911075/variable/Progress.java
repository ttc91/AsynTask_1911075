package com.android.s1911075.variable;

public class Progress {

    private int progress;
    private String workingValue;

    public Progress(int progress, String workingValue) {
        this.progress = progress;
        this.workingValue = workingValue;
    }
    public int getProgress() {
        return progress;
    }

    public String getWorkingInfo() {
        return workingValue;
    }

}
