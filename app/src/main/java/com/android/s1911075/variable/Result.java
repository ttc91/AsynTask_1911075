package com.android.s1911075.variable;

public class Result {

    private boolean completed;
    private long workTimeInMillis;

    public Result(boolean completed, long workTimeInMillis) {
        this.completed = completed;
        this.workTimeInMillis = workTimeInMillis;
    }

    public boolean isCompleted() {
        return completed;
    }

    public long getWorkTimeInMillis() {
        return workTimeInMillis;
    }

    public String getMessage() {
        if(this.completed)  {
            return "Complete !";
        }
        return "Not complete !";
    }

}
