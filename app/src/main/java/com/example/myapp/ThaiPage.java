package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;
import androidx.activity.EdgeToEdge;
import android.content.Intent;

public class ThaiPage extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private ArrayList<String> texts;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thai_page);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonRandom = findViewById(R.id.button_random);

        texts = new ArrayList<>();

        random = new Random();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = editText.getText().toString();
                if (!newText.isEmpty()) {
                    texts.add(newText);
                    editText.setText("");
                }
            }
        });

        buttonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!texts.isEmpty()) {
                    int randomIndex = random.nextInt(texts.size());
                    String randomText = texts.get(randomIndex);
                    textView.setText(randomText);
                } else {
                    textView.setText("คุณยังไม่ได้ใส่เมนูอาหารเลย");
                }
            }
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThaiPage.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }
}

