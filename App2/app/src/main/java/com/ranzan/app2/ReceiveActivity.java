package com.ranzan.app2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiveActivity extends AppCompatActivity {
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        text = findViewById(R.id.tv);
        Intent intent = getIntent();
        String data = intent.getStringExtra("key");
        text.setText(data);

    }
}