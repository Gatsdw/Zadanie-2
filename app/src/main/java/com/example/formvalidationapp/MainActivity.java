package com.example.formvalidationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editPhoneNumber;
    private EditText editPassword;
    private EditText editConfirmPassword;
    private EditText editTextSurname;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Powiązanie widoków z kodem
        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);
        editPassword = findViewById(R.id.editPassword);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pobranie wprowadzonych danych
                String name = editTextName.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String phone = editPhoneNumber.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                String confirm = editConfirmPassword.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();

                // Walidacja danych
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imię", Toast.LENGTH_SHORT).show();
                } else if (surname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić adres e-mail", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Nieprawidłowy adres e-mail", Toast.LENGTH_SHORT).show();
                } else if (phone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić numer telefonu", Toast.LENGTH_SHORT).show();
                } else if (phone.length() != 9) {
                    Toast.makeText(MainActivity.this, "Nieprawidłowy numer telefonu, musi zawierac 9 cyfr", Toast.LENGTH_SHORT).show();
                } else if(password.length() < 6) {
                    Toast.makeText(MainActivity.this, "Hasło powinno zawierać przynajmniej 6 liter", Toast.LENGTH_SHORT).show();
                } else if(confirm.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę potwierdzić hasło", Toast.LENGTH_SHORT).show();
                } else if(!password.equals(confirm)) {
                    Toast.makeText(MainActivity.this, "Hasła się nie zgadzają", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(MainActivity.this, "Formularz przesłany", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }