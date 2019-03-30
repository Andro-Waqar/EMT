package com.softwindevs.emt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class FirstAidActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;

    ArrayList<Model> arrayList = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);

        setTitle("First Aid");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        title = new String[]{"Heart Attack", "Stroke", "Breathing Problem", "Road Accident", "Epilepsy"};
        description = new String[]{"A blockage of blood flow to the heart muscle.", "Damage to the brain from interruption of its blood supply.", "Shortness of breath.", "Person is injured", "A disorder in which nerve cell activity in the brain is disturbed, causing seizures."};
        icon = new int[]{R.drawable.ic_heartattack, R.drawable.ic_stroke, R.drawable.ic_breadthingissue, R.drawable.ic_trafficaccident, R.drawable.ic_epilepsy};

        listView = (ListView) findViewById(R.id.listView);

        for (int i = 0; i < title.length; i++) {
            Model mode1 = new Model(title[i], description[i], icon[i]);
            arrayList.add(mode1);

        }

        adapter = new ListViewAdapter(this, arrayList);
        listView.setAdapter((ListViewAdapter) adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();


        if(id==R.id.action_search)
        {
            return true;

        }
        return super.onOptionsItemSelected(item);
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