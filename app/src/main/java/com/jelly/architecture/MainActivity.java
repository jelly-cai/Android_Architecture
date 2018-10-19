package com.jelly.architecture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jelly.simplemvp.main.MvpMainActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMvp = findViewById(R.id.btn_mvp);
        btnMvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MvpMainActivity.class);
                startActivity(intent);
            }
        });
    }

}
