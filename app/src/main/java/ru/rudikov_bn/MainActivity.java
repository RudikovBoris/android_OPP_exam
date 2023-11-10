package ru.rudikov_bn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.rudikov_bn.armstrong.Armstrong;
import ru.rudikov_bn.friends_number.FriendsNumber;
import ru.rudikov_bn.kaprecara.Kapricara;
import ru.rudikov_bn.kapricara_square.KapricaraSquare;
import ru.rudikov_bn.kita_package.Kita;
import ru.rudikov_bn.niven_pacage.Niven;
import ru.rudikov_bn.base_function.BaseFunction;
import ru.rudikov_bn.best_number.BestNumber;
import ru.rudikov_bn.happy_number.HappyNumber;
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

        LogWindow logWindow = new LogWindow(findViewById(R.id.log_id));
        logWindow.out("Запуск приложения");

        EditText rangeStart = findViewById(R.id.range_start_id);
        EditText rangeFinish = findViewById(R.id.range_finish_id);

        BaseFunction baseFunction = new BaseFunction(logWindow, rangeStart, rangeFinish);

        Button zuckermanButton = findViewById(R.id.search_button_zuckerman);
        zuckermanButton.setOnClickListener(v -> baseFunction.getResultCalculation(Zuckerman.class));

        Button nivenButton = findViewById(R.id.search_button_niven);
        nivenButton.setOnClickListener(v -> baseFunction.getResultCalculation(Niven.class));

        Button lisherButton = findViewById(R.id.search_button_lishler);
        lisherButton.setOnClickListener(v -> baseFunction.getResultCalculation(Lishler.class));

        Button bestNumberButton = findViewById(R.id.search_button_best_number);
        bestNumberButton.setOnClickListener(v -> baseFunction.getResultCalculation(BestNumber.class));

        Button happyNumberButton = findViewById(R.id.search_button_happy_number);
        happyNumberButton.setOnClickListener(v -> baseFunction.getResultCalculation(HappyNumber.class));

        Button kitaNumberButton = findViewById(R.id.search_button_kita);
        kitaNumberButton.setOnClickListener(v -> baseFunction.getResultCalculation(Kita.class));

        Button kaprecaraNumberButton = findViewById(R.id.search_button_kaprecara);
        kaprecaraNumberButton.setOnClickListener(v -> baseFunction.getResultCalculation(Kapricara.class));

        Button kaprecaraSquareNumberButton = findViewById(R.id.search_button_kaprecara_square);
        kaprecaraSquareNumberButton.setOnClickListener(v -> baseFunction.getResultCalculation(KapricaraSquare.class));

        Button armstrongButton = findViewById(R.id.search_button_armstrong);
        armstrongButton.setOnClickListener(v -> baseFunction.getResultCalculation(Armstrong.class));

        Button frandsButton = findViewById(R.id.search_button_friends_numbers);
        frandsButton.setOnClickListener(v -> baseFunction.getResultCalculation(FriendsNumber.class));


        Button clearButton = findViewById(R.id.clear_button_id);
        clearButton.setOnClickListener(v -> logWindow.clearView());
    }


}