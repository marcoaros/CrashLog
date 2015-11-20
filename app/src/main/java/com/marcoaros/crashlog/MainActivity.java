package com.marcoaros.crashlog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.code.microlog4android.config.PropertyConfigurator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *  Log的配置文件需要在程序的入口activity调用
         */
        PropertyConfigurator.getConfigurator(this).configure();

        FileUtil.createAppFolder();
    }
}
