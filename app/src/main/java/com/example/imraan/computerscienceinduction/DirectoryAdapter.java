package com.example.imraan.computerscienceinduction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Imraan on 28/01/2017.
 */

public class DirectoryAdapter extends BaseAdapter{

    private Context mContext;
    private List<Directory> mListDirectory;

    public DirectoryAdapter(Context context, List<Directory> list) {
        mContext = context;
        mListDirectory = list;
    }
    @Override
    public int getCount() {
        return mListDirectory.size();
    }

    @Override
    public Object getItem(int i) {
        return mListDirectory.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Directory entry = mListDirectory.get(i);

        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.phonebook_row, null);
        }

        ImageView ivAvatar = (ImageView)view.findViewById(R.id.imgAvatar);
        ivAvatar.setImageBitmap(entry.getmAvatar());

        TextView tvName = (TextView)view.findViewById(R.id.tvName);
        tvName.setText(entry.getmName());

        TextView tvPhone = (TextView)view.findViewById(R.id.tvPhone);
        tvPhone.setText(entry.getmPhone());

        TextView tvEmail = (TextView)view.findViewById(R.id.tvEmail);
        tvEmail.setText(entry.getmEmail());

        TextView tvLocation = (TextView)view.findViewById(R.id.tvLocation);
        tvLocation.setText(entry.getmLocation());
        return view;
    }
}
