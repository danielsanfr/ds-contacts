package br.com.danielsan.dscontacts.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import br.com.danielsan.dscontacts.R;
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
        binding.nvgtVw.setNavigationItemSelectedListener(onNavigationItemSelected);
    }

    private final NavigationView.OnNavigationItemSelectedListener onNavigationItemSelected = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            item.setChecked(true);
            binding.drwLyt.closeDrawers();
            return false;
        }
    };

}
