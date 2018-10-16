package com.sangbas.tadamuseum.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sangbas.tadamuseum.R;
import com.sangbas.tadamuseum.model.ArtObject;
import com.sangbas.tadamuseum.ui.HomeFragment.OnListFragmentInteractionListener;
import com.sangbas.tadamuseum.ui.dummy.DummyContent.DummyItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<ArtObject> mValues;
    private final OnListFragmentInteractionListener mListener;
    private View view;

    public MyItemRecyclerViewAdapter(List<ArtObject> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getTitle());
        Picasso.get()
                .load(mValues.get(position).getWebImage().getUrl())
                .resize(100, 100)
                .centerCrop()
                .into(holder.mThumbView);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
                Intent detailIntent = new Intent(view.getContext(),ArtDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", mValues.get(position).getTitle());
                bundle.putString("image", mValues.get(position).getWebImage().getUrl());
                detailIntent.putExtras(bundle);
                view.getContext().startActivity(detailIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public final ImageView mThumbView;
        public ArtObject mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mThumbView = (ImageView) view.findViewById(R.id.thumb);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
