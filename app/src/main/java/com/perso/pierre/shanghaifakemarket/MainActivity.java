package com.perso.pierre.shanghaifakemarket;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.ContentViewEvent;
import com.crashlytics.android.answers.CustomEvent;
import com.crashlytics.android.ndk.CrashlyticsNdk;

import java.util.prefs.Preferences;

import io.fabric.sdk.android.Fabric;


public class MainActivity extends Activity {

    private Dialog dialog;
    private TextView mTvDialogTitle;
    private TextView mTvDialogDescription;
    private TextView mTvDialogYes;
    private TextView mTvDialogNo;
    private TextView mTvDialogLater;

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Fabric.with(this, new Answers(), new Crashlytics());

        setContentView(R.layout.activity_main);


        SharedPreferences sharedPreferences;

        sharedPreferences = getPreferences(0);
        int count = sharedPreferences.getInt("numRun", 0);
        count++;
        sharedPreferences.edit().putInt("numRun", count).commit();

        int a = count;

        if (count == 5) {
            displyDialogRate(v);
        }


    }


    public void displyDialogRate(View ctx) {
        dialog = createCustomAskingToRate();
        dialog.show();
    }


    private Dialog createCustomAskingToRate() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom_dialog_asking_rate_app);

        mTvDialogTitle = (TextView) dialog.findViewById(R.id.custom_dialog_rating_title);
        mTvDialogDescription = (TextView) dialog.findViewById(R.id.custom_dialog_rating_content);
        mTvDialogYes = (TextView) dialog.findViewById(R.id.tv_custom_dialog_rate_yes);
        mTvDialogNo = (TextView) dialog.findViewById(R.id.tv_custom_dialog_rate_no);

        mTvDialogNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        mTvDialogYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("market://details?id=" + getApplication().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
                }
                dialog.dismiss();
            }
        });

        return dialog;
    }


    public void clickCommandments(View view) {
        Answers.getInstance().logCustom(new CustomEvent("click_main")
                .putCustomAttribute("click_main", "Commandements"));
        Intent intent = new Intent(this, Commandments.class);
        this.startActivity(intent);
    }

    public void clickPriceList(View view) {
        Answers.getInstance().logCustom(new CustomEvent("click_main")
                .putCustomAttribute("click_main", "Liste des prix"));
        Intent intent = new Intent(this, PriceList.class);
        this.startActivity(intent);
    }

    public void clickVocabulary(View view) {
        Answers.getInstance().logCustom(new CustomEvent("click_main")
                .putCustomAttribute("click_main", "Vocabulaire"));
        Intent intent = new Intent(this, Vocabulary.class);
        this.startActivity(intent);
    }

    public void clickLocation(View view) {
        Answers.getInstance().logCustom(new CustomEvent("click_main")
                .putCustomAttribute("click_main", "Location"));
        Intent intent = new Intent(this, Locations.class);
        this.startActivity(intent);
    }

    public void clickConverter(View view) {
        Answers.getInstance().logCustom(new CustomEvent("click_main")
                .putCustomAttribute("click_main", "COnvertisseur"));
        Intent intent = new Intent(this, ConvertCurrency.class);
        this.startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
