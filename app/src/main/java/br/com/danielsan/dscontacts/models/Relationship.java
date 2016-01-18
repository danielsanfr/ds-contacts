package br.com.danielsan.dscontacts.models;

import android.os.Parcel;
import android.os.Parcelable;

import br.com.danielsan.dscontacts.dao.DaoSession;

/**
 * Created by daniel on 18/01/16.
 */
public class Relationship extends br.com.danielsan.dscontacts.dao.Relationship implements Parcelable {

    public Relationship() { }

    public Relationship(Long id) {
        super(id);
    }

    public Relationship(Long id, String content, long contactId, Long tagId) {
        super(id, content, contactId, tagId);
    }

    public Relationship(br.com.danielsan.dscontacts.dao.Relationship relationship) {
        super(relationship.getId(), relationship.getContent(), relationship.getContactId(),
              relationship.getTagId());
    }

    protected Relationship(Parcel in) {
        this.setId(in.readLong());
        this.setContent(in.readString());
        this.setContactId(in.readLong());
        this.setTagId(in.readLong());
    }

    public void setDaoSession(DaoSession daoSession) {
        this.__setDaoSession(daoSession);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.getId());
        dest.writeString(this.getContent());
        dest.writeLong(this.getContactId());
        dest.writeLong(this.getTagId());
    }

    @Override
    public int describeContents() {
        return 4;
    }

    public static final Creator<Relationship> CREATOR = new Creator<Relationship>() {
        public Relationship createFromParcel(Parcel source) {
            return new Relationship(source);
        }
        public Relationship[] newArray(int size) {
            return new Relationship[size];
        }
    };

}
