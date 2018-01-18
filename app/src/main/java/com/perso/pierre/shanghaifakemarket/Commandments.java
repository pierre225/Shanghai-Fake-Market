package com.perso.pierre.shanghaifakemarket;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class Commandments extends Activity {



    private CommandmentsAdapter adapter;
    private ListView mCommandmentListView;
    private ArrayList<ModelCommandment> mArrayListOfCOmmandement;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commandments);

	//list of commandements
        mArrayListOfCOmmandement = new ArrayList<ModelCommandment>();
        ModelCommandment commandment1 = new ModelCommandment("I", this.getString(R.string.commandments_1));
        ModelCommandment commandment2 = new ModelCommandment("II", this.getString(R.string.commandments_2));
        ModelCommandment commandment3 = new ModelCommandment("III", this.getString(R.string.commandments_3));
        ModelCommandment commandment4 = new ModelCommandment("IV", this.getString(R.string.commandments_4));
        ModelCommandment commandment5 = new ModelCommandment("V", this.getString(R.string.commandments_5));
        ModelCommandment commandment6 = new ModelCommandment("VI", this.getString(R.string.commandments_6));
        ModelCommandment commandment7 = new ModelCommandment("VII", this.getString(R.string.commandments_7));
        ModelCommandment commandment8 = new ModelCommandment("VIII", this.getString(R.string.commandments_8));
        ModelCommandment commandment9 = new ModelCommandment("IX", this.getString(R.string.commandments_9));
        ModelCommandment commandment10 = new ModelCommandment("X", this.getString(R.string.commandments_10));



        mArrayListOfCOmmandement.add(commandment1);
        mArrayListOfCOmmandement.add(commandment2);
        mArrayListOfCOmmandement.add(commandment3);
        mArrayListOfCOmmandement.add(commandment4);
        mArrayListOfCOmmandement.add(commandment5);
        mArrayListOfCOmmandement.add(commandment6);
        mArrayListOfCOmmandement.add(commandment7);
        mArrayListOfCOmmandement.add(commandment8);
        mArrayListOfCOmmandement.add(commandment9);
        mArrayListOfCOmmandement.add(commandment10);



        mCommandmentListView = (ListView) findViewById(R.id.commandment_lv_commandments);


        adapter = new CommandmentsAdapter(mArrayListOfCOmmandement, getApplicationContext());
        mCommandmentListView.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_commandments, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
