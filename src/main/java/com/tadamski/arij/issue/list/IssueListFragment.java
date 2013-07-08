package com.tadamski.arij.issue.list;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.actionbarsherlock.app.SherlockFragment;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EFragment;
import com.googlecode.androidannotations.annotations.ViewById;
import com.tadamski.arij.R;
import com.tadamski.arij.account.service.LoginInfo;
import com.tadamski.arij.issue.resource.IssueService;
import com.tadamski.arij.issue.resource.model.Issue;
import com.tadamski.arij.issue.single.activity.single.view.IssueActivity_;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: tmszdmsk
 * Date: 09.04.13
 * Time: 20:09
 * To change this template use File | Settings | File Templates.
 */
@EFragment(R.layout.issue_list_fragment)
public class IssueListFragment extends SherlockFragment implements AdapterView.OnItemClickListener {

    @ViewById(android.R.id.list)
    ListView listView;
    @Bean
    IssueService issueService;
    ListAdapter issueListAdapter;
    private LoginInfo account;

    @AfterViews
    void initClickListener() {
        listView.setOnItemClickListener(this);
    }

    public void executeJql(String jql, LoginInfo account) {
        this.account = account;
        IssueListAdapter adapter = new IssueListAdapter(getActivity(), new ArrayList<Issue>(), 1, jql);
        issueListAdapter = new EndlessIssueListAdapter(issueService, getActivity(), adapter, account);
        listView.setAdapter(issueListAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Issue item = (Issue) issueListAdapter.getItem(position);
        IssueActivity_.intent(getActivity()).issueKey(item.getKey()).loginInfo(account).start();
    }
}
