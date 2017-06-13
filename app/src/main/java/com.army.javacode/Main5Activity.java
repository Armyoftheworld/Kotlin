package com.army.javacode;

import android.app.Activity;
import android.os.Bundle;

import com.army.kotlin.R;
import com.army.kotlin.Sqlhelper;
import com.army.kotlin.SqlhelperKt;

public class Main5Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Sqlhelper database = SqlhelperKt.getDatabase();
    }
}
