package br.com.danielsan.dscontacts.fragments;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by daniel on 11/01/16.
 */
public class BaseFragment extends br.com.ilhasoft.support.view.BaseFragment {

    public void addFragmentChild(@IdRes int containerViewId, Fragment fragment) {
        this.addFragment(containerViewId, fragment, false, true);
    }

    public void addFragmentChild(@IdRes int containerViewId, Fragment fragment, boolean withBackStack) {
        this.addFragment(containerViewId, fragment, withBackStack, true);
    }

    public void addFragmentChildWithoutAnimation(@IdRes int containerViewId, Fragment fragment) {
        this.addFragment(containerViewId, fragment, false, false);
    }

    public void addFragmentChildWithoutAnimation(@IdRes int containerViewId, Fragment fragment, boolean withBackStack) {
        this.addFragment(containerViewId, fragment, withBackStack, false);
    }

    private void addFragment(@IdRes int containerViewId, Fragment fragment, boolean withBackStack, boolean animated) {
        FragmentTransaction fragmentTransaction = this.getChildFragmentManager().beginTransaction();
        if (withBackStack)
            fragmentTransaction.addToBackStack(fragment.toString());
        if (animated)
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.add(containerViewId, fragment).commit();
    }

    public void replaceFragmentChild(@IdRes int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getChildFragmentManager().beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.replace(containerViewId, fragment).commit();
    }

}
