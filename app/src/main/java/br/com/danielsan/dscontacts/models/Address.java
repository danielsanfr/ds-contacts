package br.com.danielsan.dscontacts.models;

import android.os.Parcel;
import android.os.Parcelable;

import br.com.danielsan.dscontacts.dao.DaoSession;

/**
 * Created by daniel on 18/01/16.
 */
public class Address extends br.com.danielsan.dscontacts.dao.Address implements Parcelable {

    public Address() { }

    public Address(Long id) {
        super(id);
    }

    public Address(Long id, String content, long contactId, Long tagId) {
        super(id, content, contactId, tagId);
    }

    public Address(br.com.danielsan.dscontacts.dao.Address address) {
        super(address.getId(), address.getContent(), address.getContactId(), address.getTagId());
    }

    protected Address(Parcel in) {
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

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        public Address createFromParcel(Parcel source) {
            return new Address(source);
        }
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

}
