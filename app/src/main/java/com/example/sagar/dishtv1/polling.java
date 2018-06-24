package com.example.sagar.dishtv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.sagar.dishtv.R;

public class polling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polling);
        WebView browser = findViewById(R.id.webview);

        browser.loadUrl("http://dish-a-thon.herokuapp.com");
    }
}
