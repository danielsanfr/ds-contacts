package br.com.danielsan.dscontacts.models;

import android.os.Parcel;
import android.os.Parcelable;

import br.com.danielsan.dscontacts.dao.DaoSession;

/**
 * Created by daniel on 18/01/16.
 */
public class Phone extends br.com.danielsan.dscontacts.dao.Phone implements Parcelable {

    public Phone() { }

    public Phone(Long id) {
        super(id);
    }

    public Phone(Long id, String content, long contactId, Long tagId) {
        super(id, content, contactId, tagId);
    }

    public Phone(br.com.danielsan.dscontacts.dao.Phone phone) {
        super(phone.getId(), phone.getContent(), phone.getContactId(), phone.getTagId());
    }

    protected Phone(Parcel in) {
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

    public static final Creator<Phone> CREATOR = new Creator<Phone>() {
        public Phone createFromParcel(Parcel source) {
            return new Phone(source);
        }
        public Phone[] newArray(int size) {
            return new Phone[size];
        }
    };

}
