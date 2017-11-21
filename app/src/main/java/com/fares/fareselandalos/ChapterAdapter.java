package com.fares.fareselandalos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by elbhwashy on 11/20/2017.
 */

public class ChapterAdapter extends ArrayAdapter<Chapter> {
    public ChapterAdapter(@NonNull Context context,List<Chapter> chapters) {
        super(context, 0,chapters);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.chapter_list_item,parent,false);
        }
        Chapter currentChapter = getItem(position);
        TextView chapterView = (TextView)listItemView.findViewById(R.id.chapter_item);
        chapterView.setText(currentChapter.getChapterName());
        return listItemView;
    }
}
