package com.example.imraan.computerscienceinduction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.imraan.computerscienceinduction.R.id.map;

public class Location extends ActionBarActivity implements OnMapReadyCallback {

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;

    private static final LatLng bradfordUni = new LatLng(53.790925, -1.763044);

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        mDrawerList = (ListView)findViewById(R.id.navList);mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Move the camera instantly to Bradford University with a zoom of 16.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bradfordUni, 16));

        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomIn());

        // Add a marker to Horton Building and move the camera
        LatLng horton = new LatLng(53.791124, -1.765057);
        mMap.addMarker(new MarkerOptions().position(horton).title("Horton Building"));
        mMap.addMarker(new MarkerOptions().position(horton).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(horton));

        // Add a marker to Richmond Building and move the camera
        LatLng richmond = new LatLng(53.791387, -1.763445);
        mMap.addMarker(new MarkerOptions().position(richmond).title("Richmond Building"));
        mMap.addMarker(new MarkerOptions().position(richmond).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(richmond));

        // Add a marker to Chesham Building and move the camera
        LatLng chesham = new LatLng(53.790640, -1.765799);
        mMap.addMarker(new MarkerOptions().position(chesham).title("Chesham Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chesham));
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
                        Intent intent1 = new Intent(Location.this, Home.class);
                        startActivity(intent1);
                        break;
                    case 1: //Blackboard
                        Intent intent2 = new Intent(Location.this, Blackboard.class);
                        startActivity(intent2);
                        break;
                    case 2: //Lecturer Information
                        Intent intent3 = new Intent(Location.this, LecturerInfo.class);
                        startActivity(intent3);
                        break;
                    case 3: //Programme Handbooks/Specs
                        Intent intent4 = new Intent(Location.this, ProgrammeHandbooksSpecs.class);
                        startActivity(intent4);
                        break;
                    case 4: //Location
                        Intent intent5 = new Intent(Location.this, Location.class);
                        startActivity(intent5);
                        break;
                    case 5: //Virtual Tour
                        Intent intent6 = new Intent(Location.this, VirtualTour.class);
                        startActivity(intent6);
                        break;
                    case 6: //News
                        Intent intent7 = new Intent(Location.this, News.class);
                        startActivity(intent7);
                        break;
                    case 7: //Events
                        Intent intent8 = new Intent(Location.this, Events.class);
                        startActivity(intent8);
                        break;
                    case 8: //PAL
                        Intent intent9 = new Intent(Location.this, PAL.class);
                        startActivity(intent9);
                        break;
                    case 9: //Study Abroad
                        Intent intent10 = new Intent(Location.this, StudyAbroad.class);
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
            Intent intent1 = new Intent(Location.this, About.class);
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
