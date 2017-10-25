package com.example.eslam.eatit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnSignIn, btnSignUp;
    TextView txtslogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignIn = (Button) findViewById(R.id.btn_signin_main);
        btnSignUp = (Button) findViewById(R.id.btn_signup_main);
        txtslogan = (TextView) findViewById(R.id.slogan);
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/NABILA.TTF");
         txtslogan.setTypeface(face);

    }

    public void click(View view) {
        if (view.getId() == R.id.btn_signin_main) {
            Intent in = new Intent(this, SignIn.class);
            startActivity(in);

        } else if (view.getId() == R.id.btn_signup_main) {
            Intent in = new Intent(this, SignUp.class);
            startActivity(in);


        }

    }

}