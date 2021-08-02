package com.ranzan.app1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.dude.mydata");
                intent.setType("plain/text");
                intent.putExtra("key", name.getText().toString());
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activitiesList = packageManager.queryIntentActivities(intent, 0);
                if (activitiesList.size() >= 1) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Can't", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}