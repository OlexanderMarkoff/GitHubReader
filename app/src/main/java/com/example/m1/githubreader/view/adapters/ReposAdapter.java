package com.example.m1.githubreader.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.m1.githubreader.R;
import com.example.m1.githubreader.model.data.GitHubRepo;

import java.util.List;

/**
 * Created by M1 on 23.08.2016.
 */
public class ReposAdapter extends BaseAdapter {

    private final LayoutInflater mLayoutInflater;
    private List<GitHubRepo> mRepos;

    public ReposAdapter(final Context context, List<GitHubRepo> repos) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mRepos = repos;
    }

    @Override
    public int getCount() {
        return mRepos.size();
    }

    @Override
    public GitHubRepo getItem(int i) {
        return mRepos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final GitHubRepo item = getItem(i);
        final ViewHolder viewHolder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.item_repo, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mTitle.setText(item.getFullName());
        viewHolder.mDescription.setText(item.getDescription());
        return view;
    }

    public void  update(final List<GitHubRepo> repos) {
        mRepos = repos;
        notifyDataSetChanged();
    }

    private class ViewHolder {
        private final TextView mTitle;
        private final TextView mDescription;

        public ViewHolder(final View convertView) {
        mTitle = (TextView) convertView.findViewById(R.id.txt_item_title);
        mDescription = (TextView) convertView.findViewById(R.id.txt_item_description);
        }
    }
}
