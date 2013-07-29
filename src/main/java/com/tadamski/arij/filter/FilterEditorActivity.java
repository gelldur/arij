package com.tadamski.arij.filter;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.Extra;
import com.googlecode.androidannotations.annotations.FragmentById;
import com.tadamski.arij.R;
import com.tadamski.arij.account.service.LoginInfo;
import com.tadamski.arij.issue.list.IssueListFragment;
import com.tadamski.arij.issue.list.IssueListFragment_;
import com.tadamski.arij.issue.list.filters.Filter;

/**
 * Created by tmszdmsk on 29.07.13.
 */
@EActivity(R.layout.filter_editor_activity)
public class FilterEditorActivity extends SherlockFragmentActivity implements FilterEditorFragment.Listener {

    @FragmentById(R.id.fragment)
    FilterEditorFragment filterEditorFragment;
    @FragmentById(R.id.fragment2)
    IssueListFragment issueListFragment;
    @Extra
    LoginInfo loginInfo;

    @AfterViews
    void hideTestResults(){
        getSupportFragmentManager().beginTransaction().hide(issueListFragment).commit();
    }

    @Override
    public void testButtonClicked(String jql) {
        getSupportFragmentManager().beginTransaction().show(issueListFragment).addToBackStack("true").commit();
        issueListFragment.executeFilter(new Filter(jql,"dsa", jql), loginInfo);
    }
}
