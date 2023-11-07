package ru.rudikov_bn.baseFunction;

import android.widget.EditText;

import ru.rudikov_bn.Niven.Niven;
import ru.rudikov_bn.log.LogWindow;
import ru.rudikov_bn.zuckerman.Zuckerman;

public class BaseFunction {
    LogWindow logWindow;
    EditText rangeStart;
    EditText rangeFinish;
    int start, finish;
    public BaseFunction(LogWindow logWindow, EditText rangeStart, EditText rangeFinish ){
        this.logWindow = logWindow;
        this.rangeStart = rangeStart;
        this.rangeFinish = rangeFinish;


    }
    public void getZuckerman(){
        this.start= Integer.parseInt(rangeStart.getText().toString());
        this.finish= Integer.parseInt(rangeFinish.getText().toString());

        try {

            if(finish - start <=0) {
                throw new Exception("");
            }

        } catch (Exception e) {
            logWindow.out("Ошибка в диапазоне поиска");
            return;
        }

        logWindow.out(
                String.format(
                        "Диапазон поиска: от " + start + " до " + finish));

        logWindow.out("Поиск запущен");
        for (int i = start; i <= finish; ++i) {
            if (Zuckerman.isVerify(i)) {
                logWindow.out(i);
            }
        }

        logWindow.out("Поиск завершен");
    }

    public void getNiven() {
        this.start= Integer.parseInt(rangeStart.getText().toString());
        this.finish= Integer.parseInt(rangeFinish.getText().toString());

        if(finish - start <=0) {
            logWindow.out("Ошибка в диапазоне поиска");
            return;
        }

        logWindow.out("Диапазон поиска: от " + start + " до " + finish);

        logWindow.out("Поиск запущен");

        for (int i = start; i <= finish; ++i) {
            if (Niven.isVerify(i)) {
                logWindow.out(i);
            }
        }

        logWindow.out("Поиск завершен");
    }
}
