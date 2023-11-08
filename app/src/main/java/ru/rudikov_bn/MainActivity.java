package ru.rudikov_bn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.rudikov_bn.Niven.Niven;
import ru.rudikov_bn.baseFunction.BaseFunction;
import ru.rudikov_bn.lishler.Lishler;
import ru.rudikov_bn.log.LogWindow;
import ru.rudikov_bn.zuckerman.Zuckerman;

import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        LogWindow logWindow = new LogWindow( findViewById(R.id.log_id));
        logWindow.out("Запуск приложения");



        EditText rangeStart =  findViewById(R.id.range_start_id);
        EditText rangeFinish =  findViewById(R.id.range_finish_id);

        BaseFunction baseFunction = new BaseFunction(logWindow, rangeStart, rangeFinish);

        Button zuckermanButton = findViewById(R.id.search_button_zuckerman);
        Zuckerman zuckerman = new Zuckerman();
        zuckermanButton.setOnClickListener(v -> baseFunction.getResultCalculation(zuckerman));

        Button nivenButton = findViewById(R.id.search_button_niven);
        Niven niven = new Niven();
        nivenButton.setOnClickListener(v -> baseFunction.getResultCalculation(niven));

        Button lisherButton = findViewById(R.id.search_button_lishler);
        Lishler lishler = new Lishler();
        lisherButton.setOnClickListener(v -> baseFunction.getResultCalculation(lishler));

        Button clearButton =  findViewById(R.id.clear_button_id);
        clearButton.setOnClickListener(v -> logWindow.clearView());
    }


}