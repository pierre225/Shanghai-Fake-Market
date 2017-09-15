package com.perso.pierre.shanghaifakemarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Pierre on 12/12/2015.
 */
public class LocationsAdapter extends BaseAdapter {


    private List<InfoFake> mInfoFakes;
    private LayoutInflater inflater;

    public LocationsAdapter(List<InfoFake> infoFakes, Context c) {
        this.mInfoFakes = infoFakes;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public void updateList(List<InfoFake> infoFakes)
    {
        this.mInfoFakes = infoFakes;
        this.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mInfoFakes.size();
    }

    @Override
    public Object getItem(int position) {
        return mInfoFakes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        ViewHolder holder = null;

        InfoFake infoFake = mInfoFakes.get(position);

        if ( v == null)
        {
            holder = new ViewHolder();

            v = inflater.inflate(R.layout.custom_item_location, null);

            holder.tvName = (TextView) v.findViewById(R.id.custom_tv_name_fake);
            holder.tvDesc1 = (TextView) v.findViewById(R.id.custom_tv_desc1);
            holder.tvDesc2 = (TextView) v.findViewById(R.id.custom_tv_desc2);
            holder.tvDesc3 = (TextView) v.findViewById(R.id.custom_tv_desc3);

            v.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) v.getTag();


        }

        holder.tvName.setText(infoFake.getName());
        holder.tvDesc1.setText( infoFake.getDesc1() );
        holder.tvDesc2.setText( infoFake.getDesc2());
        holder.tvDesc3.setText( infoFake.getDesc3());


        return v;
    }


    private static class ViewHolder
    {
        TextView tvName;
        TextView tvDesc1;
        TextView tvDesc2;
        TextView tvDesc3;
    }

}
