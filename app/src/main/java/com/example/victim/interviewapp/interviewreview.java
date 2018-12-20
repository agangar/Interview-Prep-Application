package com.example.victim.interviewapp;

        import android.support.v7.app.AppCompatActivity;
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

       /* import static com.example.victim.interviewapp.R.id.buttonSignup;
        import static com.example.victim.interviewapp.R.id.button;
        import static com.example.victim.interviewapp.R.id.editTexttitle;
        import static com.example.victim.interviewapp.R.id.textviewposition;*/

public class interviewreview extends Activity implements View.OnClickListener{

    private Spinner spinnertype;
    private EditText editTextcompany;
    private EditText editTextadvice;
    private EditText editTextprocess;
    private EditText editTextposition;
    private EditText editTextskill;
    private Spinner editoutcome;
    private Button buttonsubmit;
    private EditText editTextquestion;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interviewreview);

        editTextcompany=(EditText) findViewById(R.id.editTextcompany);
        spinnertype=(Spinner) findViewById(R.id.spinnertype);

        editTextprocess = (EditText) findViewById(R.id.editTextprocess);
        editTextposition = (EditText) findViewById(R.id.editTextposition);
        editTextskill = (EditText) findViewById(R.id.editTextskill);
        editTextquestion = (EditText) findViewById(R.id.editTextquestion);
        editoutcome = (Spinner) findViewById(R.id.spinneroutcome);
        buttonsubmit = (Button) findViewById(R.id.buttonsubmit);
        editTextadvice=(EditText) findViewById(R.id.editTextadvice);
        databaseReference = FirebaseDatabase.getInstance().getReference("Interview");

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        buttonsubmit.setOnClickListener(this);

    }

    public void verifyInterviewReview(){
        String cname=editTextcompany.getText().toString().trim();
        String type=String.valueOf(spinnertype.getSelectedItem());
        String advice=editTextadvice.getText().toString().trim();
        String process=editTextprocess.getText().toString().trim();
        String question=editTextquestion.getText().toString().trim();
        String position=editTextposition.getText().toString().trim();
        String skill=editTextskill.getText().toString().trim();
        String outcome=String.valueOf(editoutcome.getSelectedItem());
        if(TextUtils.isEmpty(position)){
            Toast.makeText(this,"Please enter position you were Interviewed for?",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(process)){
            Toast.makeText(this,"Please enter process of the Interview",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(question)){
            Toast.makeText(this,"Please enter Question asked in the Interview",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(outcome)){
            Toast.makeText(this,"Please Select the Outcome of the interview",Toast.LENGTH_LONG).show();
            return;
        }
        String id=databaseReference.push().getKey();
        interview interviewReview=new interview(advice,cname,outcome,position,process,question,skill,type);
        databaseReference.child(id).setValue(interviewReview);
        progressDialog.setMessage("Taking u to the next Page Please Wait...");
        progressDialog.show();
        startActivity(new Intent(this,profile.class));

    }

    @Override
    public void onClick(View v) {
        verifyInterviewReview();
    }
}
