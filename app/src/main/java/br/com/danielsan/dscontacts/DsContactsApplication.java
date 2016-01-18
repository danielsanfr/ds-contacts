package br.com.danielsan.dscontacts;

import android.app.Application;
import android.content.SharedPreferences;
import android.support.v4.os.AsyncTaskCompat;
import android.support.v7.preference.PreferenceManager;

import br.com.danielsan.dscontacts.tasks.PopulateDbTask;

/**
 * Created by daniel on 17/01/16.
 */
public class DsContactsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (sharedPreferences.getBoolean("first_time", true))
            AsyncTaskCompat.executeParallel(new PopulateDbTask(this));
    }

}
