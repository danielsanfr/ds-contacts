package br.com.danielsan.dscontacts.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.fragments.ContactsFragment;
import br.com.danielsan.dscontacts.fragments.FavoritesFragment;
import br.com.ilhasoft.support.view.Activities;
import br.com.ilhasoft.support.view.BaseActivity;

import br.com.danielsan.dscontacts.databinding.ActivityMainBinding;

/**
 * Created by daniel on 28/12/15.
 */
public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void initObjects() {
        super.initObjects();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        this.setupViews();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
            return true;

        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupViews() {
        this.setupActionBar();
        this.setupDrawerLayout();
        binding.nvgtVw.setNavigationItemSelectedListener(onNavigationItemSelected);
        binding.vwPgr.setAdapter(new MainPagerAdapter(this, this.getSupportFragmentManager()));
        binding.tabLyt.setupWithViewPager(binding.vwPgr);
    }

    private void setupActionBar() {
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
                actionBar.setElevation(0);
        }
    }

    private void setupDrawerLayout() {
        drawerToggle = new DrawerToggle(this, binding.rootContent, R.string.app_name, R.string.app_name);
        binding.rootContent.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        binding.rootContent.setDrawerListener(drawerToggle);
        binding.rootContent.post(syncDrawerStateRunnable);
    }

    private final NavigationView.OnNavigationItemSelectedListener onNavigationItemSelected = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            item.setChecked(true);
            supportInvalidateOptionsMenu();
            binding.rootContent.closeDrawers();
            return false;
        }
    };

    private final Runnable syncDrawerStateRunnable = new Runnable() {
        @Override
        public void run() {
            drawerToggle.syncState();
        }
    };

    private static class DrawerToggle extends ActionBarDrawerToggle {
        private final BaseActivity activity;
        private final DrawerLayout drawerLayout;
        public DrawerToggle(BaseActivity activity, DrawerLayout drawerLayout, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
            super(activity, drawerLayout, openDrawerContentDescRes, closeDrawerContentDescRes);
            this.activity = activity;
            this.drawerLayout = drawerLayout;
        }
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            super.onDrawerSlide(drawerView, slideOffset);
            Activities.hideSoftKeyboard(activity, drawerLayout);
        }
        @Override
        public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);
            activity.supportInvalidateOptionsMenu();
        }
        @Override
        public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);
            activity.supportInvalidateOptionsMenu();
        }
    }

    private static class MainPagerAdapter extends FragmentStatePagerAdapter {
        private final Context context;
        public MainPagerAdapter(Context context, FragmentManager fragmentManager) {
            super(fragmentManager);
            this.context = context;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return (position == 0) ? context.getText(R.string.favorites) : context.getText(R.string.contacts);
        }
        @Override
        public Fragment getItem(int position) {
            return (position == 0) ? new FavoritesFragment() : new ContactsFragment();
        }
        @Override
        public int getCount() {
            return 2;
        }
    }

}
