package com.tadamski.arij.activity.account;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tadamski.arij.R;
import com.tadamski.arij.login.LoginInfo;
import com.tadamski.arij.util.Callback;

import java.util.List;

/**
 * @author tmszdmsk
 */
public class AccountListAdapter extends BaseAdapter {

    private final Context ctx;
    private final List<LoginInfo> loginInfos;
    private final Callback<LoginInfo> onAccountClickAction;
    private final LayoutInflater layoutInflater;

    public AccountListAdapter(Context ctx, List<LoginInfo> loginInfos, Callback<LoginInfo> onAccountClickAction) {
        this.ctx = ctx;
        this.loginInfos = loginInfos;
        this.onAccountClickAction = onAccountClickAction;
        this.layoutInflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return loginInfos.size();
    }

    @Override
    public LoginInfo getItem(int position) {
        return loginInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.account_list_elem, null);
        }
        final TextView userName = (TextView) convertView.findViewById(R.id.username);
        final TextView jiraUrl = (TextView) convertView.findViewById(R.id.jira_url);
        final LoginInfo item = getItem(position);
        userName.setText(item.getUsername());
        jiraUrl.setText(item.getBaseURL());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAccountClickAction.call(item);
            }
        });
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }
}
