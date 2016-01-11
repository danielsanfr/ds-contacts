package br.com.danielsan.dscontacts.activities;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by daniel on 11/01/16.
 */
public class BaseActivity extends br.com.ilhasoft.support.view.BaseActivity {

    @Override
    public void addFragment(@IdRes int containerViewId, Fragment fragment) {
        super.addFragment(containerViewId, fragment, false);
    }

    public void addFragmentWithoutAnimation(@IdRes int containerViewId, Fragment fragment) {
        this.addFragmentWithoutAnimation(containerViewId, fragment, false);
    }

    public void addFragmentWithoutAnimation(@IdRes int containerViewId, Fragment fragment, boolean withBackStack) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        if (withBackStack)
            fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.add(containerViewId, fragment).commit();
    }

}
