package com.example.eslam.eatit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eslam.eatit.Common.Common;
import com.example.eslam.eatit.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {
    Button sign_in;
    MaterialEditText ed_phone, ed_pass;
    FirebaseDatabase database;
    DatabaseReference table_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        sign_in = (Button) findViewById(R.id.btnsn_signin);
        ed_phone = (MaterialEditText) findViewById(R.id.ed_sigin_pn);
        ed_pass = (MaterialEditText) findViewById(R.id.ed_sigin_pd);
        //init firebase
        database = FirebaseDatabase.getInstance();
        table_user = database.getReference("Users");
    }

    public void click(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(SignIn.this);
        progressDialog.setMessage("Please Wait ....");
        progressDialog.show();
        table_user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Check if user not exists
                if (dataSnapshot.child(ed_phone.getText().toString()).exists()) {
                    //Get User Information
                    progressDialog.dismiss();
                    User user = dataSnapshot.child(ed_phone.getText().toString()).getValue(User.class);

                    progressDialog.dismiss();
                    if (user.getPassword().equals(ed_pass.getText().toString())) {
                        Intent intentHome = new Intent(SignIn.this, Home.class);
                        Common.currentuser = user; //to save current user
                        startActivity(intentHome);
                        finish();
                    } else
                        Toast.makeText(SignIn.this, "please Check Your Password", Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(SignIn.this, "User Doesn't Exists Please Sign in", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
