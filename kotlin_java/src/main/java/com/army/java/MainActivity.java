package com.army.java;

import android.app.Activity;
import android.os.Bundle;

import com.army.kotlin.A;
import com.army.kotlin.B;
import com.army.kotlin.D;
import com.army.kotlin.NewKotlinClass;
import com.army.kotlin.Utils;
import com.army.kotlin_java.R;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewKotlinClass.getName();//使用顶层属性
        System.out.println(NewKotlinClass.name1);
        Utils.a();
        Utils.b();
        NewKotlinClass.test(1);
        NewKotlinClass.test("1");
        NewKotlinClass.test2(new ArrayList<Integer>());
        NewKotlinClass.test1(new ArrayList<String>());

        new A("").getName();//只能通过get获取
        String name = new B("").name;
        B.C.getAge();//使用kotlin伴生对象

        //使用kotlin声明对象（object）
        D.INSTANCE.getName();

        NewKotlinClass.getDefault();
        NewKotlinClass.getDefault("name");
        NewKotlinClass.getDefault("name", 10);

        try {
            NewKotlinClass.ex();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
