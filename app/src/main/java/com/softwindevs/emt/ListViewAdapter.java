package com.softwindevs.emt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



/**
 * Created by waqar naik on 15/3/19.
 */

public class ListViewAdapter extends BaseAdapter {

    Context mcontext;
    LayoutInflater inflater;
    List<Model> mode1list;
    ArrayList<Model> arraylist;

    public ListViewAdapter(Context context, List<Model> mode1list) {
        mcontext = context;
        this.mode1list = mode1list;

        inflater = LayoutInflater.from(mcontext);
        this.arraylist = new ArrayList<Model>();
        this.arraylist.addAll(mode1list);

    }


    public class ViewHolder
    {
        TextView mTitleTv,mDescTv;
        ImageView mIconTv;

    }
    @Override
    public int getCount() {
        return mode1list.size();
    }

    @Override
    public Object getItem(int i) {
        return mode1list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        ViewHolder holder;
        if(view==null)
        {

            holder=new ViewHolder();
            view=inflater.inflate(R.layout.row,null);

            holder.mTitleTv= (TextView) view.findViewById(R.id.maintile);
            holder.mDescTv= (TextView) view.findViewById(R.id.maindescription);
            holder.mIconTv= (ImageView) view.findViewById(R.id.mainIcon);
            view.setTag(holder);
        }

        else
        {

            holder=(ViewHolder)view.getTag();

        }
        holder.mTitleTv.setText(mode1list.get(position).getTitle());
        holder.mDescTv.setText(mode1list.get(position).getDesc());
        holder.mIconTv.setImageResource(mode1list.get(position).getIcon());



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == 0){
                    Intent i = new Intent(mcontext, FirstAidInfoActivity.class);
                    i.putExtra("keyHTML","file:///android_asset/heartattack.html");
                    mcontext.startActivity(i);

                }
                if (position == 1){
                    Intent i = new Intent(mcontext, FirstAidInfoActivity.class);
                    i.putExtra("keyHTML","file:///android_asset/stroke.html");
                    mcontext.startActivity(i);

                }
                if (position == 2){
                    Intent i = new Intent(mcontext, FirstAidInfoActivity.class);
                    i.putExtra("keyHTML","file:///android_asset/breathing.html");
                    mcontext.startActivity(i);

                }
                if (position == 3){
                    Intent i = new Intent(mcontext, FirstAidInfoActivity.class);
                    i.putExtra("keyHTML","file:///android_asset/accident.html");
                    mcontext.startActivity(i);

                }
                if (position == 4){
                    Intent i = new Intent(mcontext, FirstAidInfoActivity.class);
                    i.putExtra("keyHTML","file:///android_asset/eli.html");
                    mcontext.startActivity(i);

                }



            }
        });
        return view;
    }

    public void  filter(String charText)
    {


        charText=charText.toLowerCase(Locale.getDefault());
        mode1list.clear();


        if(charText.length()==0)
        {
            mode1list.addAll(arraylist);
        }

        else
        {
            for (Model mode1:arraylist)
            {
                if(mode1.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText))
                {
                    mode1list.add(mode1);

                }


            }

        }
        notifyDataSetChanged();

    }
}
