package com.example.imraan.computerscienceinduction;

/**
 * Created by Imraan on 07/02/2017.
 */

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProgrammeHandbooksSpecs extends ActionBarActivity {

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);

        mDrawerList = (ListView)findViewById(R.id.navList);mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub

                final String selected = (String) listAdapter.getChild(
                        groupPosition, childPosition);

                // Switch case to open selected child element activity on child element selection.
                switch(selected){
                    case "Software Engineering Handbook":
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("http://www.bradford.ac.uk/timetabling/timetables/ei/software-engineering-beng/BEng_Software_Engineering-2016-17.pdf"));
                        startActivity(intent);
                        break;
                    case "Software Engineering Specification":
                        Intent intent1 = new Intent();
                        intent1.setAction(Intent.ACTION_VIEW);
                        intent1.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent1.setData(Uri.parse("http://www.bradford.ac.uk/aqpo/programme-specifications/2016-17/engineering-and-informatics/school-of-electrical-engineering-and-computer-science/beng-software-engineering-hon.pdf"));
                        startActivity(intent1);
                        break;
                    case "Business Computing Handbook":
                        Intent intent2 = new Intent();
                        intent2.setAction(Intent.ACTION_VIEW);
                        intent2.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent2.setData(Uri.parse("http://www.bradford.ac.uk/timetabling/timetables/ei/business-computing/BSc_Business_Computing.pdf"));
                        startActivity(intent2);
                        break;
                    case "Business Computing Specification":
                        Intent intent3 = new Intent();
                        intent3.setAction(Intent.ACTION_VIEW);
                        intent3.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent3.setData(Uri.parse("http://www.bradford.ac.uk/aqpo/programme-specifications/2016-17/engineering-and-informatics/school-of-electrical-engineering-and-computer-science/bsc-business-computing-hon-2016-17-only.pdf"));
                        startActivity(intent3);
                        break;
                    case "Computer Science Handbook":
                        Intent intent4 = new Intent();
                        intent4.setAction(Intent.ACTION_VIEW);
                        intent4.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent4.setData(Uri.parse("http://www.bradford.ac.uk/timetabling/timetables/ei/computer-science-bsc/BSc_Computer_Science_ProgrammeHandbook_2016-17.pdf"));
                        startActivity(intent4);
                        break;
                    case "Computer Science Specification":
                        Intent intent5 = new Intent();
                        intent5.setAction(Intent.ACTION_VIEW);
                        intent5.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent5.setData(Uri.parse("http://www.bradford.ac.uk/aqpo/programme-specifications/2016-17/engineering-and-informatics/school-of-electrical-engineering-and-computer-science/bsc-computer-science-hon.pdf"));
                        startActivity(intent5);
                        break;
                    case "Computer Science for Games Handbook":
                        Intent intent6 = new Intent();
                        intent6.setAction(Intent.ACTION_VIEW);
                        intent6.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent6.setData(Uri.parse("http://www.bradford.ac.uk/timetabling/timetables/ei/computer-science-for-games-bsc/BSc-Computer-Science-for-Games-Programme-Handbook-2016-17.pdf"));
                        startActivity(intent6);
                        break;
                    case "Computer Science for Games Specification":
                        Intent intent7 = new Intent();
                        intent7.setAction(Intent.ACTION_VIEW);
                        intent7.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent7.setData(Uri.parse("http://www.bradford.ac.uk/aqpo/programme-specifications/2016-17/engineering-and-informatics/school-of-electrical-engineering-and-computer-science/bsc-computer-science-for-games-hon.pdf"));
                        startActivity(intent7);
                        break;
                    case "Big Data Science and Technology Handbook":
                        Intent intent8 = new Intent();
                        intent8.setAction(Intent.ACTION_VIEW);
                        intent8.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent8.setData(Uri.parse("http://www.bradford.ac.uk/timetabling/timetables/ei/big-data-science-and-technology-msc/MSc_Big_Data_Science_and_Technology-2016-17.pdf"));
                        startActivity(intent8);
                        break;
                    case "Big Data Science and Technology Specification":
                        Intent intent9 = new Intent();
                        intent9.setAction(Intent.ACTION_VIEW);
                        intent9.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent9.setData(Uri.parse("http://www.bradford.ac.uk/aqpo/programme-specifications/2016-17/engineering-and-informatics/school-of-electrical-engineering-and-computer-science/msc-big-data-science-and-technology.pdf"));
                        startActivity(intent9);
                        break;
                    case "Cyber Security Handbook":
                        Intent intent10 = new Intent();
                        intent10.setAction(Intent.ACTION_VIEW);
                        intent10.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent10.setData(Uri.parse("http://www.bradford.ac.uk/timetabling/timetables/ei/cyber-security-msc/MSc_Cyber_Security-2016-17.pdf"));
                        startActivity(intent10);
                        break;
                    case "Cyber Security Specification":
                        Intent intent11 = new Intent();
                        intent11.setAction(Intent.ACTION_VIEW);
                        intent11.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent11.setData(Uri.parse("http://www.bradford.ac.uk/aqpo/programme-specifications/2016-17/engineering-and-informatics/school-of-electrical-engineering-and-computer-science/msc-cyber-security-final.pdf"));
                        startActivity(intent11);
                        break;
                    case "Software Engineering Stage 1 Semester 1 Timetable":
                        Intent intent12 = new Intent();
                        intent12.setAction(Intent.ACTION_VIEW);
                        intent12.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent12.setData(Uri.parse("http://www.bradford.ac.uk/timetable-files/BEng%20Software%20Engineering%20-%20Stage%201%20-%20Sem%201.pdf?v=1487540433"));
                        startActivity(intent12);
                        break;
                    case "Software Engineering Stage 1 Semester 2 Timetable":
                        Intent intent13 = new Intent();
                        intent13.setAction(Intent.ACTION_VIEW);
                        intent13.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent13.setData(Uri.parse("http://www.bradford.ac.uk/timetable-files/BEng%20Software%20Engineering%20-%20Stage%201%20-%20Sem%202.pdf?v=1487540433"));
                        startActivity(intent13);
                        break;
                    case "Software Engineering Induction Timetable":
                        Intent intent14 = new Intent();
                        intent14.setAction(Intent.ACTION_VIEW);
                        intent14.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent14.setData(Uri.parse("http://www.bradford.ac.uk/timetabling/timetables/ei/software-engineering-beng/Induction-EECS-UG-092016.pdf"));
                        startActivity(intent14);
                        break;
                    case "Business Computing Stage 1 Semester 1 Timetable":
                        Intent intent15 = new Intent();
                        intent15.setAction(Intent.ACTION_VIEW);
                        intent15.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent15.setData(Uri.parse("http://www.bradford.ac.uk/timetable-files/BSc%20Business%20Computing%20-%20Stage%201%20-%20Sem%201.pdf?v=1487541483"));
                        startActivity(intent15);
                        break;
                    case "Business Computing Stage 1 Semester 2 Timetable":
                        Intent intent16 = new Intent();
                        intent16.setAction(Intent.ACTION_VIEW);
                        intent16.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent16.setData(Uri.parse("http://www.bradford.ac.uk/timetable-files/BSc%20Business%20Computing%20-%20Stage%201%20-%20Sem%202.pdf?v=1487541483"));
                        startActivity(intent16);
                        break;
                    case "Business Computing Induction Timetable":
                        Intent intent17 = new Intent();
                        intent17.setAction(Intent.ACTION_VIEW);
                        intent17.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent17.setData(Uri.parse("http://www.bradford.ac.uk/timetabling/timetables/ei/business-computing/Induction-EECS-UG-092016.pdf"));
                        startActivity(intent17);
                        break;
                    case "Computer Science Stage 1 Semester 1 Timetable":
                        Intent intent18 = new Intent();
                        intent18.setAction(Intent.ACTION_VIEW);
                        intent18.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent18.setData(Uri.parse("http://www.bradford.ac.uk/timetable-files/BSc%20Computer%20Science%20-%20Stage%201%20-%20Sem%201.pdf?v=1487541748"));
                        startActivity(intent18);
                        break;
                    case "Computer Science Stage 1 Semester 2 Timetable":
                        Intent intent19 = new Intent();
                        intent19.setAction(Intent.ACTION_VIEW);
                        intent19.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent19.setData(Uri.parse("http://www.bradford.ac.uk/timetable-files/BSc%20Computer%20Science%20-%20Stage%201%20-%20Sem2.pdf?v=1487541748"));
                        startActivity(intent19);
                        break;
                    case "Computer Science Induction Timetable":
                        Intent intent20 = new Intent();
                        intent20.setAction(Intent.ACTION_VIEW);
                        intent20.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent20.setData(Uri.parse("http://www.bradford.ac.uk/timetabling/timetables/ei/computer-science-bsc/Induction-EECS-UG-092016.pdf"));
                        startActivity(intent20);
                        break;
                    case "Computer Science for Games Stage 1 Semester 1 Timetable":
                        Intent intent21 = new Intent();
                        intent21.setAction(Intent.ACTION_VIEW);
                        intent21.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent21.setData(Uri.parse("http://www.bradford.ac.uk/timetable-files/BSc%20Computer%20Science%20for%20Games%20-%20Stage%201%20-%20Sem%201.pdf?v=1487541973"));
                        startActivity(intent21);
                        break;
                    case "Computer Science for Games Stage 1 Semester 2 Timetable":
                        Intent intent22 = new Intent();
                        intent22.setAction(Intent.ACTION_VIEW);
                        intent22.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent22.setData(Uri.parse("http://www.bradford.ac.uk/timetable-files/BSc%20Computer%20Science%20for%20Games%20-%20Stage%201%20-%20Sem%202.pdf?v=1487541973"));
                        startActivity(intent22);
                        break;
                    case "Computer Science for Games Induction Timetable":
                        Intent intent23 = new Intent();
                        intent23.setAction(Intent.ACTION_VIEW);
                        intent23.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent23.setData(Uri.parse("http://www.bradford.ac.uk/timetabling/timetables/ei/computer-science-for-games-bsc/Induction-EECS-UG-092016.pdf"));
                        startActivity(intent23);
                        break;
                    case "Big Data Science and Technology Semester 1 Timetable":
                        Intent intent24 = new Intent();
                        intent24.setAction(Intent.ACTION_VIEW);
                        intent24.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent24.setData(Uri.parse("http://www.bradford.ac.uk/timetable-files/MSc%20Big%20Data%20Science%20&%20Technology%20-%20Sem%201.pdf?v=1487542271"));
                        startActivity(intent24);
                        break;
                    case "Big Data Science and Technology Semester 2 Timetable":
                        Intent intent25 = new Intent();
                        intent25.setAction(Intent.ACTION_VIEW);
                        intent25.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent25.setData(Uri.parse("http://www.bradford.ac.uk/timetable-files/MSc%20Big%20Data%20Science%20&%20Technology%20-%20Sem%202.pdf?v=1487542271"));
                        startActivity(intent25);
                        break;
                    case "Big Data Science and Technology Induction Timetable":
                        Intent intent26 = new Intent();
                        intent26.setAction(Intent.ACTION_VIEW);
                        intent26.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent26.setData(Uri.parse("http://www.bradford.ac.uk/timetabling/timetables/ei/big-data-science-and-technology-msc/EECS-PG-Induction.docx"));
                        startActivity(intent26);
                        break;
                    case "Cyber Security Semester 1 Timetable":
                        Intent intent27 = new Intent();
                        intent27.setAction(Intent.ACTION_VIEW);
                        intent27.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent27.setData(Uri.parse("http://www.bradford.ac.uk/timetable-files/MSc%20Cyber%20Security%20-%20Sem%201.pdf?v=1487542527"));
                        startActivity(intent27);
                        break;
                    case "Cyber Security Semester 2 Timetable":
                        Intent intent28 = new Intent();
                        intent28.setAction(Intent.ACTION_VIEW);
                        intent28.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent28.setData(Uri.parse("http://www.bradford.ac.uk/timetable-files/MSc%20Cyber%20Security%20-%20Sem%202.pdf?v=1487542527"));
                        startActivity(intent28);
                        break;
                    case "Cyber Security Induction Timetable":
                        Intent intent29 = new Intent();
                        intent29.setAction(Intent.ACTION_VIEW);
                        intent29.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent29.setData(Uri.parse("http://www.bradford.ac.uk/timetabling/timetables/ei/cyber-security-msc/Induction-EECS-PG-092016.pdf"));
                        startActivity(intent29);
                        break;
                }
                //Toast.makeText(
                        //getApplicationContext(),
                        //listDataHeader.get(groupPosition)
                        //        + " : "
                        //        + listDataChild.get(
                        //        listDataHeader.get(groupPosition)).get(
                        //        childPosition), Toast.LENGTH_SHORT)
                        //.show();
                return true;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("BEng Software Engineering (2016-2017)");
        listDataHeader.add("BSc Business Computing (2016-2017)");
        listDataHeader.add("BSc Computer Science (2016-2017)");
        listDataHeader.add("BSc Computer Science for Games (2016-2017)");
        listDataHeader.add("MSc Big Data Science and Technology (2016-2017)");
        listDataHeader.add("MSc Cyber Security (2016-2017)");

        // Adding child data
        List<String> softwareEng = new ArrayList<String>();
        softwareEng.add("Software Engineering Handbook");
        softwareEng.add("Software Engineering Specification");
        softwareEng.add("Software Engineering Stage 1 Semester 1 Timetable");
        softwareEng.add("Software Engineering Stage 1 Semester 2 Timetable");
        softwareEng.add("Software Engineering Induction Timetable");

        List<String> busComputing = new ArrayList<String>();
        busComputing.add("Business Computing Handbook");
        busComputing.add("Business Computing Specification");
        busComputing.add("Business Computing Stage 1 Semester 1 Timetable");
        busComputing.add("Business Computing Stage 1 Semester 2 Timetable");
        busComputing.add("Business Computing Induction Timetable");

        List<String> compSci = new ArrayList<String>();
        compSci.add("Computer Science Handbook");
        compSci.add("Computer Science Specification");
        compSci.add("Computer Science Stage 1 Semester 1 Timetable");
        compSci.add("Computer Science Stage 1 Semester 2 Timetable");
        compSci.add("Computer Science Induction Timetable");

        List<String> compSciGames = new ArrayList<String>();
        compSciGames.add("Computer Science for Games Handbook");
        compSciGames.add("Computer Science for Games Specification");
        compSciGames.add("Computer Science for Games Stage 1 Semester 1 Timetable");
        compSciGames.add("Computer Science for Games Stage 1 Semester 2 Timetable");
        compSciGames.add("Computer Science for Games Induction Timetable");

        List<String> bigDataScienceTech = new ArrayList<String>();
        bigDataScienceTech.add("Big Data Science and Technology Handbook");
        bigDataScienceTech.add("Big Data Science and Technology Specification");
        bigDataScienceTech.add("Big Data Science and Technology Semester 1 Timetable");
        bigDataScienceTech.add("Big Data Science and Technology Semester 2 Timetable");
        bigDataScienceTech.add("Big Data Science and Technology Induction Timetable");

        List<String> cyberSecurity = new ArrayList<String>();
        cyberSecurity.add("Cyber Security Handbook");
        cyberSecurity.add("Cyber Security Specification");
        cyberSecurity.add("Cyber Security Semester 1 Timetable");
        cyberSecurity.add("Cyber Security Semester 2 Timetable");
        cyberSecurity.add("Cyber Security Induction Timetable");

        listDataChild.put(listDataHeader.get(0), softwareEng); // Header, Child data
        listDataChild.put(listDataHeader.get(1), busComputing);
        listDataChild.put(listDataHeader.get(2), compSci);
        listDataChild.put(listDataHeader.get(3), compSciGames);
        listDataChild.put(listDataHeader.get(4), bigDataScienceTech);
        listDataChild.put(listDataHeader.get(5), cyberSecurity);

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
                        Intent intent1 = new Intent(ProgrammeHandbooksSpecs.this, Home.class);
                        startActivity(intent1);
                        break;
                    case 1: //Blackboard
                        Intent intent2 = new Intent(ProgrammeHandbooksSpecs.this, Blackboard.class);
                        startActivity(intent2);
                        break;
                    case 2: //Lecturer Information
                        Intent intent3 = new Intent(ProgrammeHandbooksSpecs.this, LecturerInfo.class);
                        startActivity(intent3);
                        break;
                    case 3: //Programme Handbooks/Specs
                        Intent intent4 = new Intent(ProgrammeHandbooksSpecs.this, ProgrammeHandbooksSpecs.class);
                        startActivity(intent4);
                        break;
                    case 4: //Location
                        Intent intent5 = new Intent(ProgrammeHandbooksSpecs.this, Location.class);
                        startActivity(intent5);
                        break;
                    case 5: //Virtual Tour
                        Intent intent6 = new Intent(ProgrammeHandbooksSpecs.this, VirtualTour.class);
                        startActivity(intent6);
                        break;
                    case 6: //News
                        Intent intent7 = new Intent(ProgrammeHandbooksSpecs.this, News.class);
                        startActivity(intent7);
                        break;
                    case 7: //Events
                        Intent intent8 = new Intent(ProgrammeHandbooksSpecs.this, Events.class);
                        startActivity(intent8);
                        break;
                    case 8: //PAL
                        Intent intent9 = new Intent(ProgrammeHandbooksSpecs.this, PAL.class);
                        startActivity(intent9);
                        break;
                    case 9: //Study Abroad
                        Intent intent10 = new Intent(ProgrammeHandbooksSpecs.this, StudyAbroad.class);
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
            Intent intent1 = new Intent(ProgrammeHandbooksSpecs.this, About.class);
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