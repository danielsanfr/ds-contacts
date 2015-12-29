package br.com.danielsan.dscontacts.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.MenuItem;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.fragments.ContactsFragment;
import br.com.danielsan.dscontacts.fragments.FavoritesFragment;
import br.com.ilhasoft.support.view.BaseActivity;

import br.com.danielsan.dscontacts.databinding.ActivityMainBinding;

/**
 * Created by daniel on 28/12/15.
 */
public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        this.setupViews();
    }

    private void setupViews() {
        binding.nvgtVw.setNavigationItemSelectedListener(onNavigationItemSelected);
        binding.vwPgr.setAdapter(new MainPagerAdapter(this, this.getSupportFragmentManager()));
        binding.tabLyt.setupWithViewPager(binding.vwPgr);
    }

    private final NavigationView.OnNavigationItemSelectedListener onNavigationItemSelected = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            item.setChecked(true);
            binding.drwLyt.closeDrawers();
            return false;
        }
    };

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
