package com.softwindevs.emt;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class AmbulanceActivity extends AppCompatActivity {

    RelativeLayout r1,r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);
        setTitle("Ambulance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        r1= (RelativeLayout) findViewById(R.id.call_ambulance);
        r2= (RelativeLayout) findViewById(R.id.ambulance_near_me);


        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(AmbulanceActivity.this, LoginActivity.class);
             //   moveTaskToBack(true);
                startActivity(intent2);


                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "102"));
                startActivity(intent);

            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(AmbulanceActivity.this, LoginActivity.class);
                //   moveTaskToBack(true);
                startActivity(intent2);


                Intent intent = null;

                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/maps/search/ambulance+near+me/"));
                startActivity(intent);

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
