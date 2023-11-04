package ru.rudikov_bn.zuckerman;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.rudikov_bn.R;
import ru.rudikov_bn.log.Log;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Log log = new Log((TextView) findViewById(R.id.log_id));
        log.out("Запуск приложения");

        EditText rangeStart = (EditText) findViewById(R.id.range_start_id);
        EditText rangeFinish = (EditText) findViewById(R.id.range_finish_id);
        Button searchButton = (Button) findViewById(R.id.search_button_id);

        searchButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                int start = 0;
                int finish = 0;
                try {
                    start = Integer.parseInt(rangeStart.getText().toString());
                    finish = Integer.parseInt(rangeFinish.getText().toString());

                    if(finish - start <=0) {
                        throw new Exception("");
                    }

                } catch (Exception e) {
                    log.out("Ошибка в диапазоне поиска");
                    return;
                }

                log.out(
                    String.format(
                        "Диапазон поиска: от %d до %d", start, finish));

                log.out("Поиск запущен");
                for (int i = start; i <= finish; ++i) {
                    if (Zuckerman.isVerify(i)) {
                        log.out(i);
                    }
                }

                log.out("Поиск завершен");
            }
        });

        Button clearButton = (Button) findViewById(R.id.clear_button_id);
        clearButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                log.clearView();
            }
        });
    }
}
