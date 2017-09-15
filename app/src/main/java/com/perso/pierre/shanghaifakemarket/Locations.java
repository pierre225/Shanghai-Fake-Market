package com.perso.pierre.shanghaifakemarket;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Locations extends Activity {

    private LocationsAdapter adapter;
    private List<InfoFake> listFakes = new ArrayList<>();
    private ListView mFakesListView;
    private Dialog dialog;
    private ImageView mImageLocationFake;
    private TextView mName;
    private TextView mAddressEnglish;
    private TextView mAddresspinyin;
    private TextView mHoraires;
    private TextView mMetroBus;
    private TextView mDescription;
    private ArrayList<InfoFake> mArrayListOfFakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);


        InfoFake fake2 = new InfoFake("AP Plaza", this.getString(R.string.location_theme_clothes), this.getString(R.string.location_theme_electronic), this.getString(R.string.location_theme_souvenirs));
        InfoFake fake3 = new InfoFake("Fabric Market", this.getString(R.string.location_theme_clothes), this.getString(R.string.location_theme_made_to_measure));
        InfoFake fake4 = new InfoFake("Qipu Lu Clothing Market", this.getString(R.string.location_theme_clothes), this.getString(R.string.location_theme_made_to_measure));
        InfoFake fake5 = new InfoFake("Yu Garden", this.getString(R.string.location_theme_souvenirs), this.getString(R.string.location_theme_tea));

        listFakes.add(fake2);
        listFakes.add(fake3);
        listFakes.add(fake4);
        listFakes.add(fake5);


        mArrayListOfFakes = new ArrayList<InfoFake>();
        InfoFake fake2fullEntry = new InfoFake("AP Plaza", R.drawable.ap_plaza_location, "2000 Shiji DaDao, near Yingchun road" , "地铁2号线上海科技馆站内, 世纪大道2000号, 近迎春路", this.getString(R.string.emplacement_fake2), this.getString(R.string.horaires_fake2), this.getString(R.string.fake_2_description));
        InfoFake fake3fullEntry = new InfoFake("South Bund Fabric Market", R.drawable.south_bund_fabric_market_location, "399 jiabang Lu, near Nancang Jie" , "南外滩轻纺面料市场, 陆家浜路399号, 近南仓街 ", this.getString(R.string.emplacement_fake3), this.getString(R.string.horaires_fake3), this.getString(R.string.fake_3_description));
        InfoFake fake4fullEntry = new InfoFake("Qipu Lu Clothing Market", R.drawable.qipu_lu, "168 Qipu Lu, near Henan Bei Lu" , "七浦路168号，近河南北路", this.getString(R.string.emplacement_fake4), this.getString(R.string.horaires_fake4), this.getString(R.string.fake_4_description));
        InfoFake fake5fullEntry = new InfoFake("Yuyuan Garden", R.drawable.yuyuan_garden_location, "137 Anren Jie,near Fuyou Lu" , "豫园, 安仁街137号, 近福佑路", this.getString(R.string.emplacement_fake5), this.getString(R.string.horaires_fake5), this.getString(R.string.fake_5_description));



        mArrayListOfFakes.add(fake2fullEntry);
        mArrayListOfFakes.add(fake3fullEntry);
        mArrayListOfFakes.add(fake4fullEntry);
        mArrayListOfFakes.add(fake5fullEntry);


        mFakesListView = (ListView) findViewById(R.id.location_lv_listview);


        adapter = new LocationsAdapter(listFakes, getApplicationContext());
        mFakesListView.setAdapter(adapter);


        mFakesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                onClickItemLocationInfo(view, position);

            }
        });


    }

    public void onClickItemLocationInfo(View ctx, int position) {
        dialog = createCustomDialogInfoLocation(position);
        dialog.show();
    }


    private Dialog createCustomDialogInfoLocation(int position) {
        final Dialog dialog = new Dialog(Locations.this);
        dialog.setContentView(R.layout.custom_dialog_info_market);
        dialog.setTitle(mArrayListOfFakes.get(position).getName());

        mName = (TextView) dialog.findViewById(R.id.custom_dialog_tv_name);
        mName.setText(mArrayListOfFakes.get(position).getName());
        mImageLocationFake = (ImageView) dialog.findViewById(R.id.custom_dialog_iv_carte);
        mImageLocationFake.setImageResource(mArrayListOfFakes.get(position).getImageLocation());
        mAddressEnglish = (TextView) dialog.findViewById(R.id.custom_dialog_tv_address_english);
        mAddressEnglish.setText(mArrayListOfFakes.get(position).getAddressEnglish());
        mAddresspinyin = (TextView) dialog.findViewById(R.id.custom_dialog_tv_address_pinyin);
        mAddresspinyin.setText(mArrayListOfFakes.get(position).getAddressPinyin());
        mHoraires = (TextView) dialog.findViewById(R.id.custom_dialog_tv_time);
        mHoraires.setText(mArrayListOfFakes.get(position).getTime());
        mMetroBus = (TextView) dialog.findViewById(R.id.custom_dialog_tv_metro);
        mMetroBus.setText(mArrayListOfFakes.get(position).getMetroBus());
        mDescription = (TextView) dialog.findViewById(R.id.custom_dialog_tv_description);
        mDescription.setText(mArrayListOfFakes.get(position).getDescription());

        mImageLocationFake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Locations.this, GoogleMapActivity.class);
                startActivity(intent);
            }
        });


        return dialog;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_locations, menu);
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
