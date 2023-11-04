package ru.rudikov_bn.log;

import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Log {

    private TextView textView;

    public Log(TextView textView) {
        this.textView = textView;
        this.textView.setMovementMethod(new ScrollingMovementMethod());
    }

    public void out(String msg) {
        this.textView.append(String.format("[%s] %s\n", getDateTime(), msg));
    }    

    public void out(int msg) {
        this.textView.append(String.format("[%s] %d\n", getDateTime(), msg));
    }

    public void clearView() {
        this.textView.setText("");
    }

    private String getDateTime() {
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd, hh:mm:ss.SSS");
        return df.format(Calendar.getInstance().getTime());
    }

}
