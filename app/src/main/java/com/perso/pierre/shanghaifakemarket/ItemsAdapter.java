package com.perso.pierre.shanghaifakemarket;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Pierre on 12/12/2015.
 */
public class ItemsAdapter extends BaseAdapter {


    private List<ModelItem> mItems;
    private LayoutInflater inflater;


    public ItemsAdapter(List<ModelItem> items, Context c) {
        this.mItems = items;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public void updateList(List<ModelItem> items) {
        this.mItems = items;
        this.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        ViewHolder holder = null;

        ModelItem item = mItems.get(position);

        if (v == null) {
            holder = new ViewHolder();

            v = inflater.inflate(R.layout.custom_item_item_info, null);

            holder.tvName = (TextView) v.findViewById(R.id.custom_item_item_info_tv_name_item);
            holder.tvMin = (TextView) v.findViewById(R.id.custom_item_item_info_tv_price_min);
            holder.tvMax = (TextView) v.findViewById(R.id.custom_item_item_info_tv_price_max);
            holder.ivImage = (ImageView) v.findViewById(R.id.custom_item_item_info_iv_image);
            holder.llBackground = (LinearLayout) v.findViewById(R.id.ll_custom_item_item_background);
            holder.tvCat = (TextView) v.findViewById(R.id.tv_custom_item_item_categorie);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();


        }


        holder.tvName.setText(item.getName());
        holder.tvMin.setText(item.getPriceMin());
        holder.tvMax.setText(item.getPriceMax());
        holder.ivImage.setImageResource(item.getImage());
        if (item.getCat().equals("clothe")) {
            holder.llBackground.setBackgroundColor(Color.parseColor("#00A600"));
            holder.tvCat.setVisibility(View.GONE);
            if (item.getName().equals(v.getResources().getString(R.string.item_1))) {
                holder.tvCat.setVisibility(View.VISIBLE);
                holder.tvCat.setText(R.string.item_adapter_category_clothes);
            }
        } else if (item.getCat().equals("electronic")) {
            holder.llBackground.setBackgroundColor(Color.parseColor("#FEC200"));
            holder.tvCat.setVisibility(View.GONE);
            if (item.getName().equals(v.getResources().getString(R.string.item_41))) {
                holder.tvCat.setVisibility(View.VISIBLE);
                holder.tvCat.setText(R.string.item_adapter_category_electronics);
            }
        } else if (item.getCat().equals("others")) {
            holder.llBackground.setBackgroundColor(Color.parseColor("#0091FE"));
            holder.tvCat.setVisibility(View.GONE);
            if (item.getName().equals(v.getResources().getString(R.string.item_26))) {
                holder.tvCat.setVisibility(View.VISIBLE);
                holder.tvCat.setText(R.string.item_adapter_category_others);
            }
        }


            return v;
        }


        private static class ViewHolder {
            TextView tvName;
            TextView tvMin;
            TextView tvMax;
            TextView tvCat;
            ImageView ivImage;
            LinearLayout llBackground;
        }

    }
