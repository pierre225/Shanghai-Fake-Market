package com.perso.pierre.shanghaifakemarket;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class PriceList extends Activity {

    private ListView mItemListView;
    private ItemsAdapter adapter;
    private List<ModelItem> listItems = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_list);




        listItems.add(new ModelItem(this.getString(R.string.item_1), "30", "40", R.drawable.ic_teeshirtsimple, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_2), "40", "50", R.drawable.ic_teeshirtgood, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_3), "40", "60", R.drawable.ic_polo, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_4), "120", "140", R.drawable.ic_traditionaldress, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_5), "90", "110", R.drawable.ic_hoodies, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_6), "60", "100", R.drawable.ic_jeans, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_7), "100", "120", R.drawable.ic_dresspants, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_8), "60", "80", R.drawable.ic_casualshoes, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_9), "90", "110", R.drawable.ic_sportshoes, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_10), "150", "250", R.drawable.ic_dressshoes, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_11), "130", "140", R.drawable.ic_uggs, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_12), "25", "30", R.drawable.ic_crocs, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_13), "6", "7", R.drawable.ic_socks, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_14), "6", "9", R.drawable.ic_maleunderwear, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_15), "25", "35", R.drawable.ic_belt, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_16), "30", "40", R.drawable.ic_cap, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_17), "70", "100", R.drawable.ic_sportshirt, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_18), "15", "35", R.drawable.ic_scarf, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_19), "55", "65", R.drawable.ic_bag, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_20), "80", "100", R.drawable.ic_backpack, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_21), "100", "200", R.drawable.ic_suitcase, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_22), "30", "50", R.drawable.ic_wallet, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_23), "200", "500", R.drawable.ic_coat, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_24), "15", "20", R.drawable.ic_tie, "clothe"));
        listItems.add(new ModelItem(this.getString(R.string.item_25), "100", "200", R.drawable.ic_purse, "clothe"));



        listItems.add(new ModelItem(this.getString(R.string.item_41), "8", "10", R.drawable.ic_film, "electronic"));
        listItems.add(new ModelItem(this.getString(R.string.item_42), "12", "17", R.drawable.ic_softwaregames, "electronic"));
        listItems.add(new ModelItem(this.getString(R.string.item_43), "10", "15", R.drawable.ic_softwaregames, "electronic"));
        listItems.add(new ModelItem(this.getString(R.string.item_44), "80", "100", R.drawable.ic_rcdevicesmall, "electronic"));
        listItems.add(new ModelItem(this.getString(R.string.item_45), "100", "130", R.drawable.ic_rcdevicebig, "electronic"));
        listItems.add(new ModelItem(this.getString(R.string.item_46), "20", "25", R.drawable.ic_carger, "electronic"));
        listItems.add(new ModelItem(this.getString(R.string.item_47), "30", "40", R.drawable.ic_tabletcover, "electronic"));
        listItems.add(new ModelItem(this.getString(R.string.item_48), "20", "25", R.drawable.ic_phonecover, "electronic"));
        listItems.add(new ModelItem(this.getString(R.string.item_49), "100", "120", R.drawable.ic_headphone, "electronic"));
        listItems.add(new ModelItem(this.getString(R.string.item_50), "40", "70", R.drawable.ic_speakers, "electronic"));
        listItems.add(new ModelItem(this.getString(R.string.item_51), "15", "20", R.drawable.ic_flashlight, "electronic"));
        listItems.add(new ModelItem(this.getString(R.string.item_52), "20", "40", R.drawable.ic_laser, "electronic"));
        listItems.add(new ModelItem(this.getString(R.string.item_53), "5", "10", R.drawable.ic_lighter, "electronic"));


        listItems.add(new ModelItem(this.getString(R.string.item_26), "60", "100", R.drawable.ic_binoculars, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_27), "50", "60", R.drawable.ic_kite, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_28), "50", "60", R.drawable.ic_ecigarette, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_29), "7", "9", R.drawable.ic_cards, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_30), "7", "9", R.drawable.ic_chineseknot, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_31), "10", "15", R.drawable.ic_shot, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_32), "30", "40", R.drawable.ic_chopsticks, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_33), "50", "80", R.drawable.ic_tea_set, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_34), "5", "10", R.drawable.ic_poster, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_35), "10", "20", R.drawable.ic_chinesefan, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_36), "10", "15", R.drawable.ic_keychain, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_37), "35", "40", R.drawable.ic_notebook, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_38), "15", "25", R.drawable.ic_pen, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_39), "20", "25", R.drawable.ic_watchsimple, "others"));
        listItems.add(new ModelItem(this.getString(R.string.item_40), "100", "130", R.drawable.ic_watchgood, "others"));


        mItemListView = (ListView) findViewById(R.id.price_list_lv_listview);

        adapter = new ItemsAdapter(listItems, getApplicationContext());
        mItemListView.setAdapter(adapter);







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_price_list, menu);
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
