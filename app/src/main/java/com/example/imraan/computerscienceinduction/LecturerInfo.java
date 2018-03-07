package com.example.imraan.computerscienceinduction;

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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Imraan on 23/02/2017.
 */

public class LecturerInfo extends ActionBarActivity {

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
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

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
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub

                final String selected = (String) listAdapter.getChild(
                        groupPosition, childPosition);

                // Switch case to open selected child element activity on child element selection.
                switch(selected){
                    case "Miss Lorna Armitage's Profile":
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=larmita2"));
                        startActivity(intent);
                        break;
                    case "Phone Extension: 3937":
                        String number = "+441274233937";
                        Intent intent1 = new Intent(Intent.ACTION_DIAL);
                        intent1.setData(Uri.parse("tel:" + number));
                        startActivity(intent1);
                        break;
                    case "Email: L.Armitage2@Bradford.ac.uk":
                        Intent intent2 = new Intent(Intent.ACTION_SEND);
                        intent2.setType("message/rfc822");
                        intent2.putExtra(Intent.EXTRA_EMAIL, new String[] { "L.Armitage2@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent2, "Send email via..."));
                        break;
                    case "Dr Taufiq Asyhari's Profile":
                        Intent intent3 = new Intent();
                        intent3.setAction(Intent.ACTION_VIEW);
                        intent3.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent3.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=atasyhar"));
                        startActivity(intent3);
                        break;
                    case "Phone Extension: 6008":
                        String number1 = "+441274236008";
                        Intent intent4 = new Intent(Intent.ACTION_DIAL);
                        intent4.setData(Uri.parse("tel:" + number1));
                        startActivity(intent4);
                        break;
                    case "Email: A.T.Asyhari@Bradford.ac.uk":
                        Intent intent5 = new Intent(Intent.ACTION_SEND);
                        intent5.setType("message/rfc822");
                        intent5.putExtra(Intent.EXTRA_EMAIL, new String[] { "A.T.Asyhari@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent5, "Send email via..."));
                        break;
                    case "Professor Irfan Awan's Profile":
                        Intent intent6 = new Intent();
                        intent6.setAction(Intent.ACTION_VIEW);
                        intent6.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent6.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=iawan"));
                        startActivity(intent6);
                        break;
                    case "Phone Extension: 3952":
                        String number2 = "+441274233952";
                        Intent intent7 = new Intent(Intent.ACTION_DIAL);
                        intent7.setData(Uri.parse("tel:" + number2));
                        startActivity(intent7);
                        break;
                    case "Email: I.U.Awan@Bradford.ac.uk":
                        Intent intent8 = new Intent(Intent.ACTION_SEND);
                        intent8.setType("message/rfc822");
                        intent8.putExtra(Intent.EXTRA_EMAIL, new String[] { "I.U.Awan@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent8, "Send email via..."));
                        break;
                    case "Dr Attila Csenki's Profile":
                        Intent intent9 = new Intent();
                        intent9.setAction(Intent.ACTION_VIEW);
                        intent9.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent9.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=acsenki"));
                        startActivity(intent9);
                        break;
                    case "Phone Extension: 4277":
                        String number3 = "+441274234277";
                        Intent intent10 = new Intent(Intent.ACTION_DIAL);
                        intent10.setData(Uri.parse("tel:" + number3));
                        startActivity(intent10);
                        break;
                    case "Email: A.Csenki@Bradford.ac.uk":
                        Intent intent11 = new Intent(Intent.ACTION_SEND);
                        intent11.setType("message/rfc822");
                        intent11.putExtra(Intent.EXTRA_EMAIL, new String[] { "A.Csenki@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent11, "Send email via..."));
                        break;
                    case "Dr Andrea Cullen's Profile":
                        Intent intent12 = new Intent();
                        intent12.setAction(Intent.ACTION_VIEW);
                        intent12.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent12.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=ajcullen"));
                        startActivity(intent12);
                        break;
                    case "Phone Extension: 5689":
                        String number4 = "+441274235689";
                        Intent intent13 = new Intent(Intent.ACTION_DIAL);
                        intent13.setData(Uri.parse("tel:" + number4));
                        startActivity(intent13);
                        break;
                    case "Email: A.J.Cullen@Bradford.ac.uk":
                        Intent intent14 = new Intent(Intent.ACTION_SEND);
                        intent14.setType("message/rfc822");
                        intent14.putExtra(Intent.EXTRA_EMAIL, new String[] { "A.J.Cullen@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent14, "Send email via..."));
                        break;
                    case "Professor Rae Earnshaw's Profile":
                        Intent intent15 = new Intent();
                        intent15.setAction(Intent.ACTION_VIEW);
                        intent15.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent15.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=raearnsh"));
                        startActivity(intent15);
                        break;
                    case "Phone Extension: 6131":
                        String number5 = "+441274236131";
                        Intent intent16 = new Intent(Intent.ACTION_DIAL);
                        intent16.setData(Uri.parse("tel:" + number5));
                        startActivity(intent16);
                        break;
                    case "Email: R.A.Earnshaw@Bradford.ac.uk":
                        Intent intent17 = new Intent(Intent.ACTION_SEND);
                        intent17.setType("message/rfc822");
                        intent17.putExtra(Intent.EXTRA_EMAIL, new String[] { "R.A.Earnshaw@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent17, "Send email via..."));
                        break;
                    case "Mr David Forbe's Profile":
                        Intent intent18 = new Intent();
                        intent18.setAction(Intent.ACTION_VIEW);
                        intent18.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent18.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=dforbes"));
                        startActivity(intent18);
                        break;
                    case "Phone Extension: 5738":
                        String number6 = "+441274235738";
                        Intent intent19 = new Intent(Intent.ACTION_DIAL);
                        intent19.setData(Uri.parse("tel:" + number6));
                        startActivity(intent19);
                        break;
                    case "Email: D.Forbes@Bradford.ac.uk":
                        Intent intent20 = new Intent(Intent.ACTION_SEND);
                        intent20.setType("message/rfc822");
                        intent20.putExtra(Intent.EXTRA_EMAIL, new String[] { "D.Forbes@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent20, "Send email via..."));
                        break;
                    case "Professor Marian Gheorghe's Profile":
                        Intent intent21 = new Intent();
                        intent21.setAction(Intent.ACTION_VIEW);
                        intent21.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent21.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=mgheorgh"));
                        startActivity(intent21);
                        break;
                    case "Phone Extension: 3930":
                        String number7 = "+441274233930";
                        Intent intent22 = new Intent(Intent.ACTION_DIAL);
                        intent22.setData(Uri.parse("tel:" + number7));
                        startActivity(intent22);
                        break;
                    case "Email: M.Gheorghe@Bradford.ac.uk":
                        Intent intent23 = new Intent(Intent.ACTION_SEND);
                        intent23.setType("message/rfc822");
                        intent23.putExtra(Intent.EXTRA_EMAIL, new String[] { "M.Gheorghe@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent23, "Send email via..."));
                        break;
                    case "Mr Karim Hammoud's Profile":
                        Intent intent24 = new Intent();
                        intent24.setAction(Intent.ACTION_VIEW);
                        intent24.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent24.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=asadik"));
                        startActivity(intent24);
                        break;
                    case "Phone Extension: 3935":
                        String number8 = "+441274233935";
                        Intent intent25 = new Intent(Intent.ACTION_DIAL);
                        intent25.setData(Uri.parse("tel:" + number8));
                        startActivity(intent25);
                        break;
                    case "Email: A.Sadik@Bradford.ac.uk":
                        Intent intent26 = new Intent(Intent.ACTION_SEND);
                        intent26.setType("message/rfc822");
                        intent26.putExtra(Intent.EXTRA_EMAIL, new String[] { "A.Sadik@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent26, "Send email via..."));
                        break;
                    case "Dr Rob Holton's Profile":
                        Intent intent27 = new Intent();
                        intent27.setAction(Intent.ACTION_VIEW);
                        intent27.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent27.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=drwholto"));
                        startActivity(intent27);
                        break;
                    case "Phone Extension: 3909":
                        String number9 = "+441274233909";
                        Intent intent28 = new Intent(Intent.ACTION_DIAL);
                        intent28.setData(Uri.parse("tel:" + number9));
                        startActivity(intent28);
                        break;
                    case "Email: D.R.W.Holton@Bradford.ac.uk":
                        Intent intent29 = new Intent(Intent.ACTION_SEND);
                        intent29.setType("message/rfc822");
                        intent29.putExtra(Intent.EXTRA_EMAIL, new String[] { "D.R.W.Holton@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent29, "Send email via..."));
                        break;
                    case "Dr Mumtaz Kamala's Profile":
                        Intent intent30 = new Intent();
                        intent30.setAction(Intent.ACTION_VIEW);
                        intent30.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent30.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=makamala"));
                        startActivity(intent30);
                        break;
                    case "Phone Extension: 4032":
                        String number10 = "+441274234032";
                        Intent intent31 = new Intent(Intent.ACTION_DIAL);
                        intent31.setData(Uri.parse("tel:" + number10));
                        startActivity(intent31);
                        break;
                    case "Email: M.A.Kamala@Bradford.ac.uk":
                        Intent intent32 = new Intent(Intent.ACTION_SEND);
                        intent32.setType("message/rfc822");
                        intent32.putExtra(Intent.EXTRA_EMAIL, new String[] { "M.A.Kamala@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent32, "Send email via..."));
                        break;
                    case "Dr Savas Konur's Profile":
                        Intent intent33 = new Intent();
                        intent33.setAction(Intent.ACTION_VIEW);
                        intent33.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent33.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=makamala"));
                        startActivity(intent33);
                        break;
                    case "Phone Extension: 5857":
                        String number11 = "+441274235857";
                        Intent intent34 = new Intent(Intent.ACTION_DIAL);
                        intent34.setData(Uri.parse("tel:" + number11));
                        startActivity(intent34);
                        break;
                    case "Email: S.Konur@Bradford.ac.uk":
                        Intent intent35 = new Intent(Intent.ACTION_SEND);
                        intent35.setType("message/rfc822");
                        intent35.putExtra(Intent.EXTRA_EMAIL, new String[] { "S.Konur@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent35, "Send email via..."));
                        break;
                    case "Professor Demetres Kouvatsos' Profile":
                        Intent intent36 = new Intent();
                        intent36.setAction(Intent.ACTION_VIEW);
                        intent36.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent36.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=demetres"));
                        startActivity(intent36);
                        break;
                    case "Phone Extension: 3941":
                        String number12 = "+441274233941";
                        Intent intent37 = new Intent(Intent.ACTION_DIAL);
                        intent37.setData(Uri.parse("tel:" + number12));
                        startActivity(intent37);
                        break;
                    case "Email: D.Kouvatsos@Bradford.ac.uk":
                        Intent intent38 = new Intent(Intent.ACTION_SEND);
                        intent38.setType("message/rfc822");
                        intent38.putExtra(Intent.EXTRA_EMAIL, new String[] { "D.Kouvatsos@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent38, "Send email via..."));
                        break;
                    case "Dr Ci Lei's Profile":
                        Intent intent39 = new Intent();
                        intent39.setAction(Intent.ACTION_VIEW);
                        intent39.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent39.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=clei1"));
                        startActivity(intent39);
                        break;
                    case "Phone Extension: 3925":
                        String number13 = "+441274233925";
                        Intent intent40 = new Intent(Intent.ACTION_DIAL);
                        intent40.setData(Uri.parse("tel:" + number13));
                        startActivity(intent40);
                        break;
                    case "Email: C.Lei1@Bradford.ac.uk":
                        Intent intent41 = new Intent(Intent.ACTION_SEND);
                        intent41.setType("message/rfc822");
                        intent41.putExtra(Intent.EXTRA_EMAIL, new String[] { "C.Lei1@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent41, "Send email via..."));
                        break;
                    case "Professor Daniel Neagu's Profile":
                        Intent intent42 = new Intent();
                        intent42.setAction(Intent.ACTION_VIEW);
                        intent42.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent42.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=dneagu"));
                        startActivity(intent42);
                        break;
                    case "Phone Extension: 5704":
                        String number14 = "+441274235704";
                        Intent intent43 = new Intent(Intent.ACTION_DIAL);
                        intent43.setData(Uri.parse("tel:" + number14));
                        startActivity(intent43);
                        break;
                    case "Email: D.Neagu@Bradford.ac.uk":
                        Intent intent44 = new Intent(Intent.ACTION_SEND);
                        intent44.setType("message/rfc822");
                        intent44.putExtra(Intent.EXTRA_EMAIL, new String[] { "D.Neagu@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent44, "Send email via..."));
                        break;
                    case "Professor Rami Qahwaji's Profile":
                        Intent intent45 = new Intent();
                        intent45.setAction(Intent.ACTION_VIEW);
                        intent45.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent45.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=rsrqahwa"));
                        startActivity(intent45);
                        break;
                    case "Phone Extension: 6078":
                        String number15 = "+441274236078";
                        Intent intent46 = new Intent(Intent.ACTION_DIAL);
                        intent46.setData(Uri.parse("tel:" + number15));
                        startActivity(intent46);
                        break;
                    case "Email: R.S.R.Qahwaji@Bradford.ac.uk":
                        Intent intent47 = new Intent(Intent.ACTION_SEND);
                        intent47.setType("message/rfc822");
                        intent47.putExtra(Intent.EXTRA_EMAIL, new String[] { "R.S.R.Qahwaji@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent47, "Send email via..."));
                        break;
                    case "Mr Mick Ridley's Profile":
                        Intent intent48 = new Intent();
                        intent48.setAction(Intent.ACTION_VIEW);
                        intent48.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent48.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=mick"));
                        startActivity(intent48);
                        break;
                    case "Phone Extension: 3946":
                        String number16 = "+441274233946";
                        Intent intent49 = new Intent(Intent.ACTION_DIAL);
                        intent49.setData(Uri.parse("tel:" + number16));
                        startActivity(intent49);
                        break;
                    case "Email: M.J.Ridley@Bradford.ac.uk":
                        Intent intent50 = new Intent(Intent.ACTION_SEND);
                        intent50.setType("message/rfc822");
                        intent50.putExtra(Intent.EXTRA_EMAIL, new String[] { "M.J.Ridley@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent50, "Send email via..."));
                        break;
                    case "Dr Dhaval Thakker's Profile":
                        Intent intent51 = new Intent();
                        intent51.setAction(Intent.ACTION_VIEW);
                        intent51.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent51.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=dthakker"));
                        startActivity(intent51);
                        break;
                    case "Phone Extension: 4578":
                        String number17 = "+441274234578";
                        Intent intent52 = new Intent(Intent.ACTION_DIAL);
                        intent52.setData(Uri.parse("tel:" + number17));
                        startActivity(intent52);
                        break;
                    case "Email: D.Thakker@Bradford.ac.uk":
                        Intent intent53 = new Intent(Intent.ACTION_SEND);
                        intent53.setType("message/rfc822");
                        intent53.putExtra(Intent.EXTRA_EMAIL, new String[] { "D.Thakker@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent53, "Send email via..."));
                        break;
                    case "Dr Paul Trundle's Profile":
                        Intent intent54 = new Intent();
                        intent54.setAction(Intent.ACTION_VIEW);
                        intent54.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent54.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=prtrundl"));
                        startActivity(intent54);
                        break;
                    case "Phone Extension: 5118":
                        String number18 = "+441274235118";
                        Intent intent55 = new Intent(Intent.ACTION_DIAL);
                        intent55.setData(Uri.parse("tel:" + number18));
                        startActivity(intent55);
                        break;
                    case "Email: P.R.Trundle@Bradford.ac.uk":
                        Intent intent56 = new Intent(Intent.ACTION_SEND);
                        intent56.setType("message/rfc822");
                        intent56.putExtra(Intent.EXTRA_EMAIL, new String[] { "P.R.Trundle@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent56, "Send email via..."));
                        break;
                    case "Professor Geoff Tupholme's Profile":
                        Intent intent57 = new Intent();
                        intent57.setAction(Intent.ACTION_VIEW);
                        intent57.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent57.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=getuphol"));
                        startActivity(intent57);
                        break;
                    case "Phone Extension: 4273":
                        String number19 = "+441274234273";
                        Intent intent58 = new Intent(Intent.ACTION_DIAL);
                        intent58.setData(Uri.parse("tel:" + number19));
                        startActivity(intent58);
                        break;
                    case "Email: G.E.Tupholme@Bradford.ac.uk":
                        Intent intent59 = new Intent(Intent.ACTION_SEND);
                        intent59.setType("message/rfc822");
                        intent59.putExtra(Intent.EXTRA_EMAIL, new String[] { "G.E.Tupholme@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent59, "Send email via..."));
                        break;
                    case "Professor Apostol Vourdas' Profile":
                        Intent intent60 = new Intent();
                        intent60.setAction(Intent.ACTION_VIEW);
                        intent60.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent60.setData(Uri.parse("http://www.bradford.ac.uk/ei/electrical-engineering-and-computer-science/staff-profiles/profile/?u=avourdas"));
                        startActivity(intent60);
                        break;
                    case "Phone Extension: 3950":
                        String number20 = "+441274233950";
                        Intent intent61 = new Intent(Intent.ACTION_DIAL);
                        intent61.setData(Uri.parse("tel:" + number20));
                        startActivity(intent61);
                        break;
                    case "Email: A.Vourdas@Bradford.ac.uk":
                        Intent intent62 = new Intent(Intent.ACTION_SEND);
                        intent62.setType("message/rfc822");
                        intent62.putExtra(Intent.EXTRA_EMAIL, new String[] { "A.Vourdas@Bradford.ac.uk" });
                        startActivity(Intent.createChooser(intent62, "Send email via..."));
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
        listDataHeader.add("Miss Lorna Armitage");
        listDataHeader.add("Dr Taufiq Asyhari");
        listDataHeader.add("Professor Irfan Awan");
        listDataHeader.add("Dr Attila Csenki");
        listDataHeader.add("Dr Andrea Cullen");
        listDataHeader.add("Professor Rae Earnshaw");
        listDataHeader.add("Mr David Forbes");
        listDataHeader.add("Professor Marian Gheorghe");
        listDataHeader.add("Mr Karim Hammoud");
        listDataHeader.add("Dr Rob Holton");
        listDataHeader.add("Dr Mumtaz Kamala");
        listDataHeader.add("Dr Savas Konur");
        listDataHeader.add("Professor Demetres Kouvatsos");
        listDataHeader.add("Dr Ci Lei");
        listDataHeader.add("Professor Daniel Neagu");
        listDataHeader.add("Professor Rami Qahwaji");
        listDataHeader.add("Mr Mick Ridley");
        listDataHeader.add("Dr Dhaval Thakker");
        listDataHeader.add("Dr Paul Trundle");
        listDataHeader.add("Professor Geoff Tupholme");
        listDataHeader.add("Professor Apostol Vourdas");

        // Adding child data
        List<String> missLornaArmitage = new ArrayList<String>();
        missLornaArmitage.add("Miss Lorna Armitage's Profile");
        missLornaArmitage.add("Phone Extension: 3937");
        missLornaArmitage.add("Email: L.Armitage2@Bradford.ac.uk");
        missLornaArmitage.add("Location: Horton D4.09");

        List<String> drTaufiqAsyhari = new ArrayList<String>();
        drTaufiqAsyhari.add("Dr Taufiq Asyhari's Profile");
        drTaufiqAsyhari.add("Phone Extension: 6008");
        drTaufiqAsyhari.add("Email: A.T.Asyhari@Bradford.ac.uk");
        drTaufiqAsyhari.add("Location: Horton D4.07");

        List<String> professorIrfanAwan = new ArrayList<String>();
        professorIrfanAwan.add("Professor Irfan Awan's Profile");
        professorIrfanAwan.add("Phone Extension: 3952");
        professorIrfanAwan.add("Email: I.U.Awan@Bradford.ac.uk");
        professorIrfanAwan.add("Location: Horton D4.11");

        List<String> drAttilaCsenki = new ArrayList<String>();
        drAttilaCsenki.add("Dr Attila Csenki's Profile");
        drAttilaCsenki.add("Phone Extension: 4277");
        drAttilaCsenki.add("Email: A.Csenki@Bradford.ac.uk");
        drAttilaCsenki.add("Location: Horton D4.06");

        List<String> drAndreaCullen = new ArrayList<String>();
        drAndreaCullen.add("Dr Andrea Cullen's Profile");
        drAndreaCullen.add("Phone Extension: 5689");
        drAndreaCullen.add("Email: A.J.Cullen@Bradford.ac.uk");
        drAndreaCullen.add("Location: Horton D4.14");

        List<String> professorRaeEarnshaw = new ArrayList<String>();
        professorRaeEarnshaw.add("Professor Rae Earnshaw's Profile");
        professorRaeEarnshaw.add("Phone Extension: 6131");
        professorRaeEarnshaw.add("Email: R.A.Earnshaw@Bradford.ac.uk");
        professorRaeEarnshaw.add("Location: Horton D5.08B");

        List<String> mrDavidForbes = new ArrayList<String>();
        mrDavidForbes.add("Mr David Forbe's Profile");
        mrDavidForbes.add("Phone Extension: 5738");
        mrDavidForbes.add("Email: D.Forbes@Bradford.ac.uk");
        mrDavidForbes.add("Location: Horton D5.06A");

        List<String> professorMarianGheorghe = new ArrayList<String>();
        professorMarianGheorghe.add("Professor Marian Gheorghe's Profile");
        professorMarianGheorghe.add("Phone Extension: 3930");
        professorMarianGheorghe.add("Email: M.Gheorghe@Bradford.ac.uk");
        professorMarianGheorghe.add("Location: Horton D5.08c");

        List<String> mrKarimHammoud = new ArrayList<String>();
        mrKarimHammoud.add("Mr Karim Hammoud's Profile");
        mrKarimHammoud.add("Phone Extension: 3935");
        mrKarimHammoud.add("Email: A.Sadik@Bradford.ac.uk");
        mrKarimHammoud.add("Location: Horton D4.10");

        List<String> drRobHolton = new ArrayList<String>();
        drRobHolton.add("Dr Rob Holton's Profile");
        drRobHolton.add("Phone Extension: 3909");
        drRobHolton.add("Email: D.R.W.Holton@Bradford.ac.uk");
        drRobHolton.add("Location: Horton D4.12");

        List<String> drMumtazKamala = new ArrayList<String>();
        drMumtazKamala.add("Dr Mumtaz Kamala's Profile");
        drMumtazKamala.add("Phone Extension: 4032");
        drMumtazKamala.add("Email: M.A.Kamala@Bradford.ac.uk");
        drMumtazKamala.add("Location: Horton D5.6c");

        List<String> drSavasKonur = new ArrayList<String>();
        drSavasKonur.add("Dr Savas Konur's Profile");
        drSavasKonur.add("Phone Extension: 5857");
        drSavasKonur.add("Email: S.Konur@Bradford.ac.uk");
        drSavasKonur.add("Location: Horton D5.06d");

        List<String> professorDemetresKouvatsos = new ArrayList<String>();
        professorDemetresKouvatsos.add("Professor Demetres Kouvatsos' Profile");
        professorDemetresKouvatsos.add("Phone Extension: 3941");
        professorDemetresKouvatsos.add("Email: D.Kouvatsos@Bradford.ac.uk");
        professorDemetresKouvatsos.add("Location: Horton D4.13");

        List<String> drCiLei = new ArrayList<String>();
        drCiLei.add("Dr Ci Lei's Profile");
        drCiLei.add("Phone Extension: 3925");
        drCiLei.add("Email: C.Lei1@Bradford.ac.uk");
        drCiLei.add("Location: Horton D5.03");

        List<String> professorDanielNeagu = new ArrayList<String>();
        professorDanielNeagu.add("Professor Daniel Neagu's Profile");
        professorDanielNeagu.add("Phone Extension: 5704");
        professorDanielNeagu.add("Email: D.Neagu@Bradford.ac.uk");
        professorDanielNeagu.add("Location: Horton D5.08a");

        List<String> professorRamiQahwaji = new ArrayList<String>();
        professorRamiQahwaji.add("Professor Rami Qahwaji's Profile");
        professorRamiQahwaji.add("Phone Extension: 6078");
        professorRamiQahwaji.add("Email: R.S.R.Qahwaji@Bradford.ac.uk");
        professorRamiQahwaji.add("Location: Horton D5.08");

        List<String> mrMickRidley = new ArrayList<String>();
        mrMickRidley.add("Mr Mick Ridley's Profile");
        mrMickRidley.add("Phone Extension: 3946");
        mrMickRidley.add("Email: M.J.Ridley@Bradford.ac.uk");
        mrMickRidley.add("Location: Horton D5.04");

        List<String> drDhavalThakker = new ArrayList<String>();
        drDhavalThakker.add("Dr Dhaval Thakker's Profile");
        drDhavalThakker.add("Phone Extension: 4578");
        drDhavalThakker.add("Email: D.Thakker@Bradford.ac.uk");
        drDhavalThakker.add("Location: Horton D4.04");

        List<String> drPaulTrundle = new ArrayList<String>();
        drPaulTrundle.add("Dr Paul Trundle's Profile");
        drPaulTrundle.add("Phone Extension: 5118");
        drPaulTrundle.add("Email: P.R.Trundle@Bradford.ac.uk");
        drPaulTrundle.add("Location: Horton D4.08");

        List<String> professorGeoffTupholme = new ArrayList<String>();
        professorGeoffTupholme.add("Professor Geoff Tupholme's Profile");
        professorGeoffTupholme.add("Phone Extension: 4273");
        professorGeoffTupholme.add("Email: G.E.Tupholme@Bradford.ac.uk");
        professorGeoffTupholme.add("Location: Horton D1.19");

        List<String> professorApostolVourdas = new ArrayList<String>();
        professorApostolVourdas.add("Professor Apostol Vourdas' Profile");
        professorApostolVourdas.add("Phone Extension: 3950");
        professorApostolVourdas.add("Email: A.Vourdas@Bradford.ac.uk");
        professorApostolVourdas.add("Location: Horton D4.03");

        listDataChild.put(listDataHeader.get(0), missLornaArmitage); // Header, Child data
        listDataChild.put(listDataHeader.get(1), drTaufiqAsyhari);
        listDataChild.put(listDataHeader.get(2), professorIrfanAwan);
        listDataChild.put(listDataHeader.get(3), drAttilaCsenki);
        listDataChild.put(listDataHeader.get(4), drAndreaCullen);
        listDataChild.put(listDataHeader.get(5), professorRaeEarnshaw);
        listDataChild.put(listDataHeader.get(6), mrDavidForbes);
        listDataChild.put(listDataHeader.get(7), professorMarianGheorghe);
        listDataChild.put(listDataHeader.get(8), mrKarimHammoud);
        listDataChild.put(listDataHeader.get(9), drRobHolton);
        listDataChild.put(listDataHeader.get(10), drMumtazKamala);
        listDataChild.put(listDataHeader.get(11), drSavasKonur);
        listDataChild.put(listDataHeader.get(12), professorDemetresKouvatsos);
        listDataChild.put(listDataHeader.get(13), drCiLei);
        listDataChild.put(listDataHeader.get(14), professorDanielNeagu);
        listDataChild.put(listDataHeader.get(15), professorRamiQahwaji);
        listDataChild.put(listDataHeader.get(16), mrMickRidley);
        listDataChild.put(listDataHeader.get(17), drDhavalThakker);
        listDataChild.put(listDataHeader.get(18), drPaulTrundle);
        listDataChild.put(listDataHeader.get(19), professorGeoffTupholme);
        listDataChild.put(listDataHeader.get(20), professorApostolVourdas);

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
                        Intent intent1 = new Intent(LecturerInfo.this, Home.class);
                        startActivity(intent1);
                        break;
                    case 1: //Blackboard
                        Intent intent2 = new Intent(LecturerInfo.this, Blackboard.class);
                        startActivity(intent2);
                        break;
                    case 2: //Lecturer Information
                        Intent intent3 = new Intent(LecturerInfo.this, LecturerInfo.class);
                        startActivity(intent3);
                        break;
                    case 3: //Programme Handbooks/Specs
                        Intent intent4 = new Intent(LecturerInfo.this, ProgrammeHandbooksSpecs.class);
                        startActivity(intent4);
                        break;
                    case 4: //Location
                        Intent intent5 = new Intent(LecturerInfo.this, Location.class);
                        startActivity(intent5);
                        break;
                    case 5: //Virtual Tour
                        Intent intent6 = new Intent(LecturerInfo.this, VirtualTour.class);
                        startActivity(intent6);
                        break;
                    case 6: //News
                        Intent intent7 = new Intent(LecturerInfo.this, News.class);
                        startActivity(intent7);
                        break;
                    case 7: //Events
                        Intent intent8 = new Intent(LecturerInfo.this, Events.class);
                        startActivity(intent8);
                        break;
                    case 8: //PAL
                        Intent intent9 = new Intent(LecturerInfo.this, PAL.class);
                        startActivity(intent9);
                        break;
                    case 9: //Study Abroad
                        Intent intent10 = new Intent(LecturerInfo.this, StudyAbroad.class);
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
            Intent intent1 = new Intent(LecturerInfo.this, About.class);
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
