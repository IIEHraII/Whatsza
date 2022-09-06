package br.com.up.example.whats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText inputEditPhone, inputEditMsg;
    private TextInputLayout inputLayoutPhone, inputLayoutMsg;
    private Button buttonSend;
    String phone, msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditPhone = findViewById(R.id.edit_text_phone);
        inputEditMsg = findViewById(R.id.edit_text_msg);

        inputLayoutPhone = findViewById(R.id.input_layout_phone);
        inputLayoutMsg = findViewById(R.id.input_layout_msg);

        buttonSend = findViewById(R.id.button_send);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = inputEditMsg.getText().toString();
                phone = inputEditPhone.getText().toString();

                if (phone.isEmpty()) {
                    inputLayoutPhone.setError("Insira um número de telefone");
                    return;
                }
                if (phone.length() < 12 || phone.length() > 12) {
                    inputLayoutPhone.setError("Insira um número de telefone valido");
                    return;
                }
                if (msg.isEmpty()) {
                    inputLayoutMsg.setError("Insira a mensagem a ser enviada");
                    return;
                }

                Uri webpage = Uri.parse("https://wa.me/"+phone+"/?text="+msg);
                Intent i = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(i);
            }
        });
        }
}
