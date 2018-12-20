package com.example.victim.interviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

import java.io.IOException;

public class tips extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextcompany;
    private EditText editTextposition;
    private EditText editTexttips;
    private EditText editTextname;
    private Button buttonsubmit;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        editTextname=(EditText)findViewById(R.id.editTextname);
        editTextcompany=(EditText) findViewById(R.id.editTextcompany);
        editTextposition = (EditText) findViewById(R.id.editTextposition);
        editTexttips = (EditText) findViewById(R.id.editTexttips);
        buttonsubmit = (Button) findViewById(R.id.buttonsubmit);
        databaseReference = FirebaseDatabase.getInstance().getReference("review");
        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        buttonsubmit.setOnClickListener(this);
    }
    public void verifyTips()
    {
        String company=editTextcompany.getText().toString().trim();
        String position=editTextposition.getText().toString().trim();
        String tip=editTexttips.getText().toString().trim();
        String name=editTextname.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Please enter name",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(company)){
            Toast.makeText(this,"Please enter company name?",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(position)){
            Toast.makeText(this,"Please enter position",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(tip)){
            Toast.makeText(this,"Please enter tips",Toast.LENGTH_LONG).show();
            return;
        }

        String id=databaseReference.push().getKey();
        Tip tips=new Tip(name,company,position,tip);
        databaseReference.child(id).setValue(tips);
        progressDialog.setMessage("Taking u to the next Page Please Wait...");
        progressDialog.show();
        startActivity(new Intent(this,profile.class));
    }

    @Override
    public void onClick(View v) {
        verifyTips();
    }
}
