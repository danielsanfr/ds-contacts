package br.com.danielsan.dscontacts.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by daniel on 17/01/16.
 */
public final class DaoSessionFactory {

    private static final String FILENAME_CONTACTS_DB = "contacts.db";

    private DaoSessionFactory() { }

    public static DaoSession getInstance(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, FILENAME_CONTACTS_DB, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        return daoMaster.newSession();
    }

}
