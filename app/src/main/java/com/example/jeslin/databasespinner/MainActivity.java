package com.example.jeslin.databasespinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nametxt;
    List<String> names;
    DBhandler db;
    ArrayAdapter<String> DataAdapter;
    ArrayAdapter<String> ListAdapter;
    Spinner spinner;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBhandler(this);

        nametxt = (EditText) findViewById(R.id.nametxt);
        spinner = (Spinner) findViewById(R.id.spinner);
        lv=(ListView)findViewById(R.id.list1);

        names = new ArrayList<String>();
        names = db.getallnames();

        DataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, names);
        ListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);

        lv.setAdapter(ListAdapter);
        spinner.setAdapter(DataAdapter);

    }

    public void add(View view) {
        String name = nametxt.getText().toString().trim();
        names.add(name);
        db.addnames(name);
        //names = db.getallnames();
        Log.d("msg0000000000", names.get(0));


        DataAdapter.notifyDataSetChanged();
    }
}
