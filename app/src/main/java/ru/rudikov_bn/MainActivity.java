package ru.rudikov_bn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.rudikov_bn.tasks.armstrong.Armstrong;
import ru.rudikov_bn.tasks.friends_number.FriendsNumber;
import ru.rudikov_bn.tasks.kaprecara.Kapricara;
import ru.rudikov_bn.tasks.kapricara_square.KapricaraSquare;
import ru.rudikov_bn.tasks.kita.Kita;
import ru.rudikov_bn.tasks.niven.Niven;
import ru.rudikov_bn.base_function.BaseFunction;
import ru.rudikov_bn.tasks.best_number.BestNumber;
import ru.rudikov_bn.tasks.happy_number.HappyNumber;
import ru.rudikov_bn.tasks.lishler.Lishler;
import ru.rudikov_bn.log.LogWindow;
import ru.rudikov_bn.tasks.zuckerman.Zuckerman;

import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        LogWindow logWindow = new LogWindow(findViewById(R.id.log_id));
        logWindow.out("Запуск приложения");

        EditText rangeStart = findViewById(R.id.range_start_id);
        EditText rangeFinish = findViewById(R.id.range_finish_id);

        BaseFunction baseFunction = new BaseFunction(logWindow, rangeStart, rangeFinish);

        Button zuckermanButton = findViewById(R.id.search_button_zuckerman);
        zuckermanButton.setOnClickListener(v -> baseFunction.getResultCalculation(new Zuckerman()));

        Button nivenButton = findViewById(R.id.search_button_niven);
        nivenButton.setOnClickListener(v -> baseFunction.getResultCalculation(new Niven()));

        Button lisherButton = findViewById(R.id.search_button_lishler);
        lisherButton.setOnClickListener(v -> baseFunction.getResultCalculation(new Lishler()));

        Button bestNumberButton = findViewById(R.id.search_button_best_number);
        bestNumberButton.setOnClickListener(v ->baseFunction.getResultCalculation(new BestNumber()));

        Button happyNumberButton = findViewById(R.id.search_button_happy_number);
        happyNumberButton.setOnClickListener(v -> baseFunction.getResultCalculation(new HappyNumber()));

        Button kitaNumberButton = findViewById(R.id.search_button_kita);
        kitaNumberButton.setOnClickListener(v -> baseFunction.getResultCalculation(new Kita()));

        Button kaprecaraNumberButton = findViewById(R.id.search_button_kaprecara);
        kaprecaraNumberButton.setOnClickListener(v -> baseFunction.getResultCalculation(new Kapricara()));

        Button kaprecaraSquareNumberButton = findViewById(R.id.search_button_kaprecara_square);
        kaprecaraSquareNumberButton.setOnClickListener(v -> baseFunction.getResultCalculation(new KapricaraSquare()));

        Button armstrongButton = findViewById(R.id.search_button_armstrong);
        armstrongButton.setOnClickListener(v -> baseFunction.getResultCalculation(new Armstrong()));

        Button frandsButton = findViewById(R.id.search_button_friends_numbers);
        frandsButton.setOnClickListener(v -> baseFunction.getResultCalculation(new FriendsNumber()));


        Button clearButton = findViewById(R.id.clear_button_id);
        clearButton.setOnClickListener(v -> logWindow.clearView());
    }


}