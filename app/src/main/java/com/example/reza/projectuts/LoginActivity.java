package com.example.reza.projectuts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.reza.projectuts.LoginActivity;


public class LoginActivity extends AppCompatActivity {

    EditText username ,password; //Deklarasi object dari class EdiText
    String text1 ,text2; //Deklarasi object string
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void loginMasuk(View view) {
        //Method onClick pada Button

        username = (EditText)findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        text1 = username.getText().toString();
        text2 = password.getText().toString();

        //Kondisi jika username dan password benar maka akan menampilkan pesan text toast
        //Login sukses dan masuk ke activity 2
        if ((text1.contains("Reza"))&&((text2.contains("1234")))) {
            Toast.makeText(this, "Login Sukses", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            username.setText("");
            password.setText("");
        }

        else if ((text1.matches("")||text2.matches("")))
          /*
          Atau jika input text 1 dan text 2 kosong
           */
        {
            //Maka akan menampilkan pesan text toast
            Toast.makeText(this, "Isikan Username dan Password", Toast.LENGTH_SHORT).show();

        }

        else {
            //jika kedua kondisi diatas tidak memenuhi

            Toast.makeText(this, "Login Gagal /Username Password Salah", Toast.LENGTH_SHORT).show();
        }

    }

    public void cancel(View view) {
        finish();
    }
}
