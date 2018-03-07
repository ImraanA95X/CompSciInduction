package com.example.imraan.computerscienceinduction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class News extends AppCompatActivity {

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mDrawerList = (ListView)findViewById(R.id.navList);mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://www.bradford.ac.uk/ei/news/");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
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
                        Intent intent1 = new Intent(News.this, Home.class);
                        startActivity(intent1);
                        break;
                    case 1: //Blackboard
                        Intent intent2 = new Intent(News.this, Blackboard.class);
                        startActivity(intent2);
                        break;
                    case 2: //Lecturer Information
                        Intent intent3 = new Intent(News.this, LecturerInfo.class);
                        startActivity(intent3);
                        break;
                    case 3: //Programme Handbooks/Specs
                        Intent intent4 = new Intent(News.this, ProgrammeHandbooksSpecs.class);
                        startActivity(intent4);
                        break;
                    case 4: //Location
                        Intent intent5 = new Intent(News.this, Location.class);
                        startActivity(intent5);
                        break;
                    case 5: //Virtual Tour
                        Intent intent6 = new Intent(News.this, VirtualTour.class);
                        startActivity(intent6);
                        break;
                    case 6: //News
                        Intent intent7 = new Intent(News.this, News.class);
                        startActivity(intent7);
                        break;
                    case 7: //Events
                        Intent intent8 = new Intent(News.this, Events.class);
                        startActivity(intent8);
                        break;
                    case 8: //PAL
                        Intent intent9 = new Intent(News.this, PAL.class);
                        startActivity(intent9);
                        break;
                    case 9: //Study Abroad
                        Intent intent10 = new Intent(News.this, StudyAbroad.class);
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
            Intent intent1 = new Intent(News.this, About.class);
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