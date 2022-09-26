package br.com.up.whatsapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout cel_number_layout;
    TextInputEditText cel_number;

    TextInputLayout send_text_layout;
    TextInputEditText send_text;

    Button botao_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cel_number_layout = findViewById(R.id.cel_number_layout);
        cel_number = findViewById(R.id.cel_number);

        send_text_layout = findViewById(R.id.send_text_layout);
        send_text = findViewById(R.id.send_text);

        botao_text = findViewById(R.id.botao_text);

        botao_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

    }

    public void sendMessage() {
        String cellNumber = cel_number.getText().toString();
        String message = send_text.getText().toString();

        if (!cellNumber.isEmpty() && !message.isEmpty()) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/"+cellNumber+"?text="+message));
            startActivity(i);
        }
    }
}