package com.softwindevs.emt;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();


        b1 =(Button) findViewById(R.id.btn_first_aid);
        b2 =(Button) findViewById(R.id.btn_ambulance);
        b3 =(Button) findViewById(R.id.btn_find_blood);
        b4 =(Button) findViewById(R.id.btn_pharmacy);
        b5 =(Button) findViewById(R.id.btn_helpline);

    }

    public void exit_app(View view) {
        finish();
    }


    Intent intent = null;
    public void btn_find_blood(View view) {
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com/maps/search/blood+bank+near+me/"));
        startActivity(intent);
    }

    Intent intent2= null;
    public void btn_pharmacy(View view) {
        intent2 = new Intent(Intent.ACTION_VIEW);
        intent2.setData(Uri.parse("https://www.google.com/maps/search/pharmacy+near+me/"));
        startActivity(intent2);
    }

    public void btn_first_aid(View view) {
        startActivity(new Intent(HomeActivity.this,FirstAidActivity.class));
    }


    public void btn_helpline(View view) {

        startActivity(new Intent(HomeActivity.this,HelplineActivity.class));
    }

    public void btn_ambulance(View view) {
        startActivity(new Intent(HomeActivity.this,AmbulanceActivity.class));
    }
}
