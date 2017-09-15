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
public class CommandmentsAdapter extends BaseAdapter {


    private List<ModelCommandment> mCommandments;
    private LayoutInflater inflater;

    public CommandmentsAdapter(List<ModelCommandment> commandments, Context c) {
        this.mCommandments = commandments;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public void updateList(List<ModelCommandment> commandments)
    {
        this.mCommandments = commandments;
        this.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mCommandments.size();
    }

    @Override
    public Object getItem(int position) {
        return mCommandments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        ViewHolder holder = null;

        ModelCommandment commandment = mCommandments.get(position);

        if ( v == null)
        {
            holder = new ViewHolder();

            v = inflater.inflate(R.layout.custom_item_commandment, null);

            holder.tvNumber = (TextView) v.findViewById(R.id.custom_item_commandment_tv_number);
            holder.tvCommandment = (TextView) v.findViewById(R.id.custom_item_commandment_tv_commandment);


            v.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) v.getTag();


        }

        holder.tvNumber.setText(commandment.getNumber());
        holder.tvCommandment.setText( commandment.getCommandment());



        return v;
    }


    private static class ViewHolder
    {
        TextView tvNumber;
        TextView tvCommandment;
    }

}
