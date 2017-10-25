package com.example.eslam.eatit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eslam.eatit.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends AppCompatActivity {
    MaterialEditText ed_phone, ed_name, ed_password;
    Button btn_signup;
    FirebaseDatabase database;
    DatabaseReference table_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ed_phone = (MaterialEditText) findViewById(R.id.ed_signup_pn);
        ed_name = (MaterialEditText) findViewById(R.id.ed_signup_name);
        ed_password = (MaterialEditText) findViewById(R.id.ed_signup_pd);
        btn_signup = (Button) findViewById(R.id.btnsup_signup);
        database = FirebaseDatabase.getInstance();
        table_user = database.getReference("Users");
    }

    public void click(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(SignUp.this);
        progressDialog.setMessage("Please Wait ....");
        progressDialog.show();
        table_user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //check if phone exists
                if (dataSnapshot.child(ed_phone.getText().toString()).exists()) {
                    progressDialog.dismiss();
                    Toast.makeText(SignUp.this, "This Phone Is Already Exists", Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.dismiss();
                    User user = new User(ed_name.getText().toString(), ed_password.getText().toString());
                    table_user.child(ed_phone.getText().toString()).setValue(user);
                    Toast.makeText(SignUp.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
