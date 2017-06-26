package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nitin.desichain.Contents.ChildCategoryList;
import com.example.nitin.desichain.R;

import java.util.ArrayList;

/**
 * Created by NITIN on 23-Jun-17.
 */

public class ChildCategoryAdapter extends BaseAdapter  {

    private Context mcontext;
    private ArrayList<ChildCategoryList> arrayList;

    public ChildCategoryAdapter(Context mcontext, ArrayList<ChildCategoryList> arrayList) {
        this.mcontext = mcontext;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SinglechildviewHolder singlechildviewHolder;
        if(convertView==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.singlechildcategorylayout,null);
            singlechildviewHolder=new SinglechildviewHolder();
            singlechildviewHolder.textView= (TextView) convertView.findViewById(R.id.childcategortext);
            singlechildviewHolder.imageView= (ImageView) convertView.findViewById(R.id.childcategoryimage);
            convertView.setTag(singlechildviewHolder);
        }

        singlechildviewHolder= (SinglechildviewHolder) convertView.getTag();
        singlechildviewHolder.textView.setText(arrayList.get(position).getCHILDCATEGORYNAME());
        singlechildviewHolder.imageView.setImageResource(arrayList.get(position).getIMAGEID());




        return convertView;
    }


    public class SinglechildviewHolder{
        TextView textView;
        ImageView imageView;
    }
}
