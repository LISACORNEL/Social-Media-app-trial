package com.example.lisa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText usernameEditText = findViewById(R.id.username);
        EditText passwordEditText = findViewById(R.id.pass);
        ImageView login = findViewById(R.id.login);
        TextView forgotpassword = findViewById(R.id.forgotpassword);
        Button signup = findViewById(R.id.signup);


        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (username.isEmpty()) {
                    usernameEditText.setError("Username is required");
                    usernameEditText.requestFocus();
                    return;
                }
                else if ((password.isEmpty()) ) {

                    passwordEditText.setError("Password is required");
                    passwordEditText.requestFocus();
                    return;
                }

                // If both fields are filled, proceed with the login process
                performLogin(username, password);
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Login.this, Forgot_Password.class);
                startActivity(go);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Login.this, Signup.class);
                startActivity(go);
            }
        });
    }

    private void performLogin(String username, String password) {
        // Handle the login logic, e.g., authenticate with a server or local database
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
        // Navigate to the next screen
        Intent go = new Intent(Login.this, Dashboard.class);
        startActivity(go);
    }
}
