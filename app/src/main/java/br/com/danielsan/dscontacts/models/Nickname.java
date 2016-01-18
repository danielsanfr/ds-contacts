package br.com.danielsan.dscontacts.models;

import android.os.Parcel;
import android.os.Parcelable;

import br.com.danielsan.dscontacts.dao.DaoSession;

/**
 * Created by daniel on 18/01/16.
 */
public class Nickname extends br.com.danielsan.dscontacts.dao.Nickname implements Parcelable {

    public Nickname() { }

    public Nickname(Long id) {
        super(id);
    }

    public Nickname(Long id, String content, long contactId) {
        super(id, content, contactId);
    }

    public Nickname(br.com.danielsan.dscontacts.dao.Nickname nickname) {
        super(nickname.getId(), nickname.getContent(), nickname.getContactId());
    }

    protected Nickname(Parcel in) {
        this.setId(in.readLong());
        this.setContent(in.readString());
        this.setContactId(in.readLong());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.getId());
        dest.writeString(this.getContent());
        dest.writeLong(this.getContactId());
    }

    @Override
    public int describeContents() {
        return 3;
    }

    public static final Creator<Nickname> CREATOR = new Creator<Nickname>() {
        public Nickname createFromParcel(Parcel source) {
            return new Nickname(source);
        }
        public Nickname[] newArray(int size) {
            return new Nickname[size];
        }
    };

}
