package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nitin.desichain.Contents.FullOrderContent;
import com.example.nitin.desichain.Contents.Notifications;
import com.example.nitin.desichain.FullOrder;
import com.example.nitin.desichain.R;

import java.util.List;

import static com.example.nitin.desichain.R.drawable.grey;

/**
 * Created by Karan on 04-07-2017.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    public Context mContext;
    public List<Notifications> mNotificationsList;
    private LinearLayout mSingleNotificationLayout;

    public NotificationAdapter(Context mContext, List<Notifications> mNotificationsList) {
        this.mContext = mContext;
        this.mNotificationsList = mNotificationsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_notification, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        Notifications notifications = mNotificationsList.get(position);
        holder.mHeading.setText(notifications.getmHeading());
        holder.mImage.setImageResource(notifications.getmImage());

    }

    @Override
    public int getItemCount() {
        return mNotificationsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mHeading;
        private ImageButton mImage;


        public MyViewHolder(View view) {
            super(view);

            mHeading = (TextView) view.findViewById(R.id.heading);
            mImage = (ImageButton) view.findViewById(R.id.image);

            mSingleNotificationLayout = (LinearLayout) view.findViewById(R.id.singleNotification);
        }
    }

}
