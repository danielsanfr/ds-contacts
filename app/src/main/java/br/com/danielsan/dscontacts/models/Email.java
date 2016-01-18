package br.com.danielsan.dscontacts.models;

import android.os.Parcel;
import android.os.Parcelable;

import br.com.danielsan.dscontacts.dao.DaoSession;

/**
 * Created by daniel on 18/01/16.
 */
public class Email extends br.com.danielsan.dscontacts.dao.Email implements Parcelable {

    public Email() { }

    public Email(Long id) {
        super(id);
    }

    public Email(Long id, String content, long contactId, Long tagId) {
        super(id, content, contactId, tagId);
    }

    public Email(br.com.danielsan.dscontacts.dao.Email email) {
        super(email.getId(), email.getContent(), email.getContactId(), email.getTagId());
    }

    protected Email(Parcel in) {
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

    public static final Creator<Email> CREATOR = new Creator<Email>() {
        public Email createFromParcel(Parcel source) {
            return new Email(source);
        }
        public Email[] newArray(int size) {
            return new Email[size];
        }
    };

}
