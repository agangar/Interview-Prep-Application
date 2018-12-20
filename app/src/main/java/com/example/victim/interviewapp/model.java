package com.example.victim.interviewapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class model extends AppCompatActivity {
    DatabaseReference db;
    FirebaseHelper helper;
    Adapter adapter;
    ListView lv;
    private Button profile,interviews,tips,mcq;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.content_main);
        lv = (ListView) findViewById(R.id.lv);

        profile = (Button) findViewById(R.id.profile);
        interviews = (Button) findViewById(R.id.interviews);
        tips = (Button) findViewById(R.id.tips);
        mcq=(Button)findViewById(R.id.mcq) ;
        profile.setBackgroundResource(R.drawable.rounded_corner1);
        interviews.setBackgroundResource(R.drawable.rounded_corner1);
        tips.setBackgroundResource(R.drawable.rounded_corner1);
        mcq.setBackgroundResource(R.drawable.rounded_corner1);
        //INITIALIZE FIREBASE DB
        db = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(db);
        //ADAPTER

        adapter = new Adapter(this, helper.retrieve());
        lv.setAdapter(adapter);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //starting login activity
                startActivity(new Intent(model.this, login.class));
            }
        });
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(model.this,model1.class));
            }
        });
        interviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(model.this, "You are already in Interview Tab", Toast.LENGTH_SHORT).show();
            }
        });
        mcq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(model.this, mcq.class));
            }
        });

    }
}
class Adapter extends BaseAdapter {
    Context c;
    Animation animationUp,animationDown;
    ArrayList<interview> Interviews;
    public Adapter(Context c, ArrayList<interview> Interviews) {
        this.c = c;
        this.Interviews = Interviews;
    }
    @Override
    public int getCount() {
        return Interviews.size();
    }
    @Override
    public Object getItem(int position) {
        return Interviews.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.activity_model,parent,false);
        }
        TextView cname= (TextView) convertView.findViewById(R.id.cname);
        TextView positions= (TextView) convertView.findViewById(R.id.position);
        TextView type= (TextView) convertView.findViewById(R.id.type);
        final TextView process= (TextView) convertView.findViewById(R.id.process);
        final TextView advice= (TextView) convertView.findViewById(R.id.advice);
        final TextView outcome= (TextView) convertView.findViewById(R.id.outcome);
        final TextView question= (TextView) convertView.findViewById(R.id.question);
        final TextView skill= (TextView) convertView.findViewById(R.id.skill);
        final TextView process1= (TextView) convertView.findViewById(R.id.process1);
        final TextView advice1= (TextView) convertView.findViewById(R.id.advice1);
        final TextView outcome1= (TextView) convertView.findViewById(R.id.outcome1);
        final TextView question1= (TextView) convertView.findViewById(R.id.question1);
        final TextView skill1= (TextView) convertView.findViewById(R.id.skill1);
        process.setVisibility(View.GONE);
        advice.setVisibility(View.GONE);
        outcome.setVisibility(View.GONE);
        question.setVisibility(View.GONE);
        skill.setVisibility(View.GONE);
        process1.setVisibility(View.GONE);
        advice1.setVisibility(View.GONE);
        outcome1.setVisibility(View.GONE);
        question1.setVisibility(View.GONE);
        skill1.setVisibility(View.GONE);
        animationUp = AnimationUtils.loadAnimation(c, R.anim.go_up);
        animationDown = AnimationUtils.loadAnimation(c, R.anim.go_down);


        final interview s= (interview) this.getItem(position);
        cname.setText(s.getCname());
        positions.setText(s.getPosition());
        type.setText(s.getType());
        process.setText(s.getProcess());
        advice.setText(s.getAdvice());
        outcome.setText(s.getOutcome());
        question.setText(s.getQuestion());
        skill.setText(s.getSkill());
        //ONITECLICK
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(process.isShown()){
                    process.setVisibility(View.GONE);
                    advice.setVisibility(View.GONE);
                    outcome.setVisibility(View.GONE);
                    question.setVisibility(View.GONE);
                    skill.setVisibility(View.GONE);
                    process.startAnimation(animationUp);
                    advice.startAnimation(animationUp);
                    outcome.startAnimation(animationUp);
                    question.startAnimation(animationUp);
                    skill.startAnimation(animationUp);
                    process1.setVisibility(View.GONE);
                    advice1.setVisibility(View.GONE);
                    outcome1.setVisibility(View.GONE);
                    question1.setVisibility(View.GONE);
                    skill1.setVisibility(View.GONE);
                    process1.startAnimation(animationUp);
                    advice1.startAnimation(animationUp);
                    outcome1.startAnimation(animationUp);
                    question1.startAnimation(animationUp);
                    skill1.startAnimation(animationUp);
                }
                else{
                    process.setVisibility(View.VISIBLE);
                    advice.setVisibility(View.VISIBLE);
                    outcome.setVisibility(View.VISIBLE);
                    question.setVisibility(View.VISIBLE);
                    skill.setVisibility(View.VISIBLE);
                    process.startAnimation(animationDown);
                    advice.startAnimation(animationDown);
                    outcome.startAnimation(animationDown);
                    question.startAnimation(animationDown);
                    skill.startAnimation(animationDown);
                    process1.setVisibility(View.VISIBLE);
                    advice1.setVisibility(View.VISIBLE);
                    outcome1.setVisibility(View.VISIBLE);
                    question1.setVisibility(View.VISIBLE);
                    skill1.setVisibility(View.VISIBLE);
                    process1.startAnimation(animationDown);
                    advice1.startAnimation(animationDown);
                    outcome1.startAnimation(animationDown);
                    question1.startAnimation(animationDown);
                    skill1.startAnimation(animationDown);

                }
            }
        });
        return convertView;
    }


}
class FirebaseHelper {
    DatabaseReference db;
    ArrayList<interview> Interviews=new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    public ArrayList<interview> retrieve()
    {


        db.child("Interview").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Interviews.clear();
                for(DataSnapshot inter:dataSnapshot.getChildren()){

                    interview Interview=inter.getValue(interview.class);
                    Interviews.add(Interview);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return Interviews;
    }
}

