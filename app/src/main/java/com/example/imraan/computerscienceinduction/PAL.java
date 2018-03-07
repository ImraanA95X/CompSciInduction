package com.example.imraan.computerscienceinduction;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class PAL extends AppCompatActivity implements View.OnClickListener {

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;

    private Button buttonLeafletPAL;
    private Button buttonPowerpointPAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pal);

        mDrawerList = (ListView)findViewById(R.id.navList);mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        buttonLeafletPAL = (Button) findViewById(R.id.buttonLeafletPAL);
        buttonLeafletPAL.setOnClickListener(this);

        buttonPowerpointPAL = (Button) findViewById(R.id.buttonPowerpointPAL);
        buttonPowerpointPAL.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == buttonLeafletPAL) {
            Intent intent1 = new Intent();
            intent1.setAction(Intent.ACTION_VIEW);
            intent1.addCategory(Intent.CATEGORY_BROWSABLE);
            intent1.setData(Uri.parse("https://www.dropbox.com/s/6meqgcivlhaknqi/148503%20BU%20SDU%20PAL%20Welcome%20Pack%202016%20A5%20Leaflet%20FINAL.pdf?dl=1"));
            startActivity(intent1);
        }
        if(view == buttonPowerpointPAL) {
            Intent intent2 = new Intent();
            intent2.setAction(Intent.ACTION_VIEW);
            intent2.addCategory(Intent.CATEGORY_BROWSABLE);
            intent2.setData(Uri.parse("https://www.dropbox.com/s/d2rh1gtkve9q3fi/PAL%20Induction%20Computing%201617.pptx?dl=1"));
            startActivity(intent2);
        }
    }

    private void addDrawerItems() {
        String[] registeredMenuListArray = { "Home", "Blackboard", "Lecturer Information", "Programme Handbooks/Specs", "Location", "Virtual Tour", "News", "Events", "PAL (Peer Assisted Learning)", "Study Abroad" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, registeredMenuListArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: //Home
                        Intent intent1 = new Intent(PAL.this, Home.class);
                        startActivity(intent1);
                        break;
                    case 1: //Blackboard
                        Intent intent2 = new Intent(PAL.this, Blackboard.class);
                        startActivity(intent2);
                        break;
                    case 2: //Lecturer Information
                        Intent intent3 = new Intent(PAL.this, LecturerInfo.class);
                        startActivity(intent3);
                        break;
                    case 3: //Programme Handbooks/Specs
                        Intent intent4 = new Intent(PAL.this, ProgrammeHandbooksSpecs.class);
                        startActivity(intent4);
                        break;
                    case 4: //Location
                        Intent intent5 = new Intent(PAL.this, Location.class);
                        startActivity(intent5);
                        break;
                    case 5: //Virtual Tour
                        Intent intent6 = new Intent(PAL.this, VirtualTour.class);
                        startActivity(intent6);
                        break;
                    case 6: //News
                        Intent intent7 = new Intent(PAL.this, News.class);
                        startActivity(intent7);
                        break;
                    case 7: //Events
                        Intent intent8 = new Intent(PAL.this, Events.class);
                        startActivity(intent8);
                        break;
                    case 8: //PAL
                        Intent intent9 = new Intent(PAL.this, PAL.class);
                        startActivity(intent9);
                        break;
                    case 9: //Study Abroad
                        Intent intent10 = new Intent(PAL.this, StudyAbroad.class);
                        startActivity(intent10);
                        break;
                }
            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_about_app) {
            Intent intent1 = new Intent(PAL.this, About.class);
            startActivity(intent1);
        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }
}
