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
public class model1 extends AppCompatActivity {
    DatabaseReference db;
    FirebaseHelper1 helper;
    Adapter1 adapter;
    ListView lv;
    private Button profile,interviews,tips,mcq;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.content_main2);
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
        helper = new FirebaseHelper1(db);
        //ADAPTER

        adapter = new Adapter1(this, helper.retrieve());
        lv.setAdapter(adapter);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //starting login activity
                startActivity(new Intent(model1.this, login.class));
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(model1.this, "You are already in Tips Tab", Toast.LENGTH_SHORT).show();
            }
        });
        interviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(model1.this, model.class));
            }
        });
        mcq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(model1.this, mcq.class));
            }
        });

    }
}
class Adapter1 extends BaseAdapter {
    Context c;
    Animation animationUp,animationDown;
    ArrayList<Tip> Tips;
    public Adapter1(Context c, ArrayList<Tip> Tips) {
        this.c = c;
        this.Tips = Tips;
    }
    @Override
    public int getCount() {
        return Tips.size();
    }
    @Override
    public Object getItem(int position) {
        return Tips.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.activity_model2,parent,false);
        }
        TextView name=(TextView) convertView.findViewById(R.id.name);
        TextView cname= (TextView) convertView.findViewById(R.id.cname);
        TextView positions= (TextView) convertView.findViewById(R.id.position);
        TextView type= (TextView) convertView.findViewById(R.id.tips);


        final Tip s= (Tip) this.getItem(position);
        name.setText(s.getName());
        cname.setText(s.getCompany());
        positions.setText(s.getPosition());
        type.setText(s.getTip());

        return convertView;
    }


}
class FirebaseHelper1 {
    DatabaseReference db;
    ArrayList<Tip> Tips=new ArrayList<>();

    public FirebaseHelper1(DatabaseReference db) {
        this.db = db;
    }

    public ArrayList<Tip> retrieve()
    {


        db.child("review").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Tips.clear();
                for(DataSnapshot inter:dataSnapshot.getChildren()){

                    Tip tip=inter.getValue(Tip.class);
                    Tips.add(tip);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return Tips;
    }
}

