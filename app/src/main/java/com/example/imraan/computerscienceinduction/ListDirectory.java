package com.example.imraan.computerscienceinduction;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.button;
import static com.example.imraan.computerscienceinduction.R.id.listDirectory;

public class ListDirectory extends AppCompatActivity {

    private ListView lvDirectory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_directory);

        lvDirectory = (ListView)findViewById(listDirectory);

        List<Directory> listDirectory = new ArrayList<Directory>();
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.misslornaarmitage), "Miss Lorna Armitage", "3937", "L.Armitage2@Bradford.ac.uk", "Horton D4.09"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.drtaufiqasyhari), "Dr Taufiq Asyhari", "6008", "A.T.Asyhari@Bradford.ac.uk", "Horton D4.07"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.professorirfanawan), "Professor Irfan Awan (Head of School of Electrical Engineering and Computer Science)", "3952", "I.U.Awan@Bradford.ac.uk", "Horton D4.11"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.drattilacsenki), "Dr Attila Csenki", "4277", "A.Csenki@Bradford.ac.uk", "Horton D4.06"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.drandreacullen), "Dr Andrea Cullen", "5689", "A.J.Cullen@Bradford.ac.uk", "Horton D4.14"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.professorraeearnshaw), "Professor Rae Earnshaw", "6131", "R.A.Earnshaw@bradford.ac.uk", "Horton D5.08B"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.mrdavidforbes), "Mr David Forbes", "5738", "D.Forbes@Bradford.ac.uk", "Horton D5.06A"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.professormariangheorghe), " Professor Marian Gheorghe (Director of Research and Knowledge Transfer)", "3930", "M.Gheorghe@Bradford.ac.uk", "Horton D5.08c"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.mrkarimhammoud), "Mr Karim Hammoud", "3935", "A.Sadik@Bradford.ac.uk", "Horton D4.10"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.drrobholton), "Dr Rob Holton", "3909", "D.R.W.Holton@bradford.ac.uk", "Horton D4.12"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.drmumtazkamala), "Dr Mumtaz Kamala", "4032", "M.A.kamala@Bradford.ac.uk", "Horton D5.6c"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.ic_person_outline_black_24dp), "Dr Savas Konur", "5857", "S.Konur@Bradford.ac.uk", "Horton D5.06d"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.professordemetreskouvatsos), "Professor Demetres Kouvatsos", "3941", "D.Kouvatsos@Bradford.ac.uk", "Horton D4.13"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.drcilei), "Dr Ci Lei", "3925", "C.Lei1@Bradford.ac.uk", "Horton D5.03"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.professordanielneagu), "Professor Daniel Neagu (Head of Computer Science)", "5704", "D.Neagu@Bradford.ac.uk", "Horton D5.08a"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.professorramiqahwaji), "Professor Rami Qahwaji", "6078", "R.S.R.Qahwaji@bradford.ac.uk", "Horton D5.08"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.mrmickridley), "Mr Mick Ridley", "3946", "M.J.Ridley@bradford.ac.uk", "Horton D5.04"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.drdhavalthakker), " Dr Dhaval Thakker", "4578", "D.Thakker@Bradford.ac.uk", "Horton D4.04"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.drpaultrundle), "Dr Paul Trundle", "5118", "P.R.Trundle@bradford.ac.uk", "Horton D4.08"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.professorgeofftupholme), "Professor Geoff Tupholme", "4273", "G.E.Tupholme@Bradford.ac.uk", "Horton D1.19"));
        listDirectory.add(new Directory(BitmapFactory.decodeResource(getResources(), R.drawable.professorapostolvourdas), "Professor Apostol Vourdas", "3950", "A.Vourdas@Bradford.ac.uk", "Horton D4.03"));

        DirectoryAdapter adapter = new DirectoryAdapter(this, listDirectory);
        lvDirectory.setAdapter(adapter);
    }
}
