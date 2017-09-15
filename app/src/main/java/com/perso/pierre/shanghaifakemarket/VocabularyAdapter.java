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
public class VocabularyAdapter extends BaseAdapter {


    private List<ModelVocabulary> mVocabularys;
    private LayoutInflater inflater;

    public VocabularyAdapter(List<ModelVocabulary> vocabularys, Context c) {
        this.mVocabularys = vocabularys;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public void updateList(List<ModelVocabulary> vocabularys) {
        this.mVocabularys = vocabularys;
        this.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mVocabularys.size();
    }

    @Override
    public Object getItem(int position) {
        return mVocabularys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        ViewHolder holder = null;

        ModelVocabulary vocabulary = mVocabularys.get(position);

        if (v == null) {
            holder = new ViewHolder();

            v = inflater.inflate(R.layout.custom_item_vocabulary, null);

            holder.tvEnglish = (TextView) v.findViewById(R.id.custom_item_vocabulary_tv_english_sentence);
            holder.tvPinyin = (TextView) v.findViewById(R.id.custom_item_vocabulary_tv_chinese_pinyin_sentence);


            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();


        }

        holder.tvEnglish.setText(vocabulary.getEnglishSentence());
        holder.tvPinyin.setText(vocabulary.getPinyinSentence());



        return v;
    }


    private static class ViewHolder {
        TextView tvEnglish;
        TextView tvPinyin;

    }

}
