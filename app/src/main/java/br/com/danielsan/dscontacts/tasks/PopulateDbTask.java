package br.com.danielsan.dscontacts.tasks;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.annotation.ArrayRes;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.dao.DaoSession;
import br.com.danielsan.dscontacts.dao.DaoSessionFactory;
import br.com.danielsan.dscontacts.dao.Tag;
import br.com.danielsan.dscontacts.dao.TagDao;

/**
 * Created by daniel on 17/01/16.
 */
public class PopulateDbTask extends AsyncTask<Void, Void, Void> {

    private final Resources resources;
    private final DaoSession daoSession;

    public PopulateDbTask(Context context) {
        this.resources = context.getResources();
        this.daoSession = DaoSessionFactory.getInstance(context);
    }

    @Override
    protected Void doInBackground(Void... params) {
        TagDao tagDao = daoSession.getTagDao();
        this.addTags(tagDao, R.array.field_address_and_email, "email");
        this.addTags(tagDao, R.array.field_event, "event");
        this.addTags(tagDao, R.array.field_im, "im");
        this.addTags(tagDao, R.array.field_phone, "phone");
        this.addTags(tagDao, R.array.field_relationship, "relationship");

        return null;
    }

    private void addTags(TagDao tagDao, @ArrayRes int arrayId, String fieldName) {
        String[] tags = resources.getStringArray(arrayId);
        tagDao.insert(new Tag(null, resources.getString(R.string.other), fieldName));
        for (String tag : tags)
            tagDao.insert(new Tag(null, tag, fieldName));
    }

}
