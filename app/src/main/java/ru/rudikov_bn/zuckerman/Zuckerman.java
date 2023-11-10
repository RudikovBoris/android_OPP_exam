package ru.rudikov_bn.zuckerman;

import androidx.appcompat.app.AppCompatActivity;

import ru.rudikov_bn.Tasks;
import ru.rudikov_bn.array.Array;
import ru.rudikov_bn.number.Numeral;

public class Zuckerman extends AppCompatActivity implements Tasks {


    public boolean isVerify(int value) {
        int[] digits = Numeral.getDigits(value);
        int r = Array.multiplicationItems(digits);

        if (r == 0) {
            return false;
        }

        return value % r == 0;
    }


}
