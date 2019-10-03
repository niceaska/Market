package ru.niceaska.market;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Random;

public class MainActivity4 extends AppCompatActivity {

    private static final String PARCEL_KEY = "Parcel";

    public TestModel mData;

    private TextView textViewFirst;
    private TextView textViewSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Random random = new Random();
        textViewFirst = findViewById(R.id.first_field);
        textViewSecond = findViewById(R.id.second_field);

        if (savedInstanceState == null) {
            mData = new TestModel(Integer.toString(random.nextInt()), Integer.toString(random.nextInt()),
                    Arrays.asList("0", "1", "7"), Arrays.asList("0", "9", "7"));
            textViewFirst.setText(mData.getFirstRandom());
            textViewSecond.setText(mData.getSecondRandom());
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mData != null) {
            outState.putParcelable(PARCEL_KEY, mData);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mData = savedInstanceState.getParcelable(PARCEL_KEY);
        textViewFirst = findViewById(R.id.first_field);
        textViewSecond = findViewById(R.id.second_field);
        textViewFirst.setText(mData.getFirstRandom());
        textViewSecond.setText(mData.getSecondRandom());
        super.onRestoreInstanceState(savedInstanceState);
    }
}
