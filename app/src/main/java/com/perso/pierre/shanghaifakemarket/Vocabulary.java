package com.perso.pierre.shanghaifakemarket;

import android.app.Activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;



public class Vocabulary extends Activity {

    private VocabularyAdapter adapter;
    private ListView mVocabularyListView;
    private ArrayList<ModelVocabulary> mArrayListOfVocabulary;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);


        mArrayListOfVocabulary = new ArrayList<ModelVocabulary>();
        ModelVocabulary voc1 = new ModelVocabulary(this.getString(R.string.voca_word1_hello), "Ni hao", R.raw.nihao);
        ModelVocabulary voc2 = new ModelVocabulary(this.getString(R.string.voca_word2_how_much), "duo shao qian", R.raw.duoshaoqian);
        ModelVocabulary voc3 = new ModelVocabulary(this.getString(R.string.voca_word3_expensive), "gui", R.raw.gui);
        ModelVocabulary voc4 = new ModelVocabulary(this.getString(R.string.voca_word4_too_expensive), "tai gui", R.raw.taigui);
        ModelVocabulary voc5 = new ModelVocabulary(this.getString(R.string.voca_word5_good_quality), "zhi liang hao", R.raw.zhilianghao);
        ModelVocabulary voc6 = new ModelVocabulary(this.getString(R.string.voca_word6_bad_quality), "zhi liang yi ban", R.raw.zhiliangyiban);
        ModelVocabulary voc7 = new ModelVocabulary(this.getString(R.string.voca_word7_I_dont_have), "wo de qian bu gou", R.raw.wodeqianbugou);
        ModelVocabulary voc8 = new ModelVocabulary(this.getString(R.string.voca_word8_I_dont_want), "wo bu yao", R.raw.wobuyao);
        ModelVocabulary voc9 = new ModelVocabulary(this.getString(R.string.voca_word9_I_want_less), "pian yi dian", R.raw.pianyidian);
        ModelVocabulary voc10 = new ModelVocabulary(this.getString(R.string.voca_word10_do_you_have_other), "you mei you bie de chi ma", R.raw.youmeiyoubiedechima);
        ModelVocabulary voc11 = new ModelVocabulary(this.getString(R.string.voca_word11_bigger), "da yi hao", R.raw.dayihao);
        ModelVocabulary voc12 = new ModelVocabulary(this.getString(R.string.voca_word12_smaller), "xiao yi hao", R.raw.xiaoyihao);
        ModelVocabulary voc13 = new ModelVocabulary(this.getString(R.string.voca_word13_thank_you), "xie xie", R.raw.xiexie);
        ModelVocabulary voc14 = new ModelVocabulary(this.getString(R.string.voca_word14_goodbye), "bai bai", R.raw.byebye);


        mArrayListOfVocabulary.add(voc1);
        mArrayListOfVocabulary.add(voc2);
        mArrayListOfVocabulary.add(voc3);
        mArrayListOfVocabulary.add(voc4);
        mArrayListOfVocabulary.add(voc5);
        mArrayListOfVocabulary.add(voc6);
        mArrayListOfVocabulary.add(voc7);
        mArrayListOfVocabulary.add(voc8);
        mArrayListOfVocabulary.add(voc9);
        mArrayListOfVocabulary.add(voc10);
        mArrayListOfVocabulary.add(voc11);
        mArrayListOfVocabulary.add(voc12);
        mArrayListOfVocabulary.add(voc13);
        mArrayListOfVocabulary.add(voc14);


        mVocabularyListView = (ListView) findViewById(R.id.commandment_lv_vocabulary);


        adapter = new VocabularyAdapter(mArrayListOfVocabulary, getApplicationContext());
        mVocabularyListView.setAdapter(adapter);

        mVocabularyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), mArrayListOfVocabulary.get(i).getSpeaking());
                mp.start();

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vocabulary, menu);
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
