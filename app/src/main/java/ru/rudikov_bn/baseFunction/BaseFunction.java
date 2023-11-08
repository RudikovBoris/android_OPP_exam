package ru.rudikov_bn.baseFunction;

import android.widget.EditText;

import ru.rudikov_bn.Niven.Niven;
import ru.rudikov_bn.Tasks;
import ru.rudikov_bn.lishler.Lishler;
import ru.rudikov_bn.log.LogWindow;
import ru.rudikov_bn.zuckerman.Zuckerman;

public class BaseFunction {
    LogWindow logWindow;
    EditText rangeStart;
    EditText rangeFinish;
    int start, finish;

    public BaseFunction(LogWindow logWindow, EditText rangeStart, EditText rangeFinish) {
        this.logWindow = logWindow;
        this.rangeStart = rangeStart;
        this.rangeFinish = rangeFinish;


    }

    public void getResultCalculation(Tasks tasks) {

        this.start = Integer.parseInt(rangeStart.getText().toString());
        this.finish = Integer.parseInt(rangeFinish.getText().toString());


        if (finish - start <= 0) {
            logWindow.out("Ошибка в диапазоне поиска");
            return;
        }

        if (finish - start > 1000) {
            logWindow.out("Не рационально длинный поиск");
            return;
        }


        logWindow.out(String.format("Диапазон поиска: от " + start + " до " + finish));

        logWindow.out("Поиск запущен");
        for (int i = start; i <= finish; ++i) {
            if (fabricTasks(tasks, i)) {
                logWindow.out(i);
            }
        }

        logWindow.out("Поиск завершен");
    }

    public static boolean fabricTasks(Tasks tasks, int number) {

        if (tasks.getClass().equals(Zuckerman.class)) {
            if (Zuckerman.isVerify(number)) {
                return true;
            }
        } else if (tasks.getClass().equals(Niven.class)) {
            if (Niven.isVerify(number)) {
                return true;
            }
        } else if (tasks.getClass().equals(Lishler.class)) {
            if (Lishler.isVerify(number)) {
                return true;
            }
        }


        return false;
    }
}
