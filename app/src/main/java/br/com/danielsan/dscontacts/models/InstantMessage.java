package br.com.danielsan.dscontacts.models;

import android.os.Parcel;
import android.os.Parcelable;

import br.com.danielsan.dscontacts.dao.DaoSession;

/**
 * Created by daniel on 18/01/16.
 */
public class InstantMessage extends br.com.danielsan.dscontacts.dao.InstantMessage implements Parcelable {

    public InstantMessage() { }

    public InstantMessage(Long id) {
        super(id);
    }

    public InstantMessage(Long id, String content, long contactId, Long tagId) {
        super(id, content, contactId, tagId);
    }

    public InstantMessage(br.com.danielsan.dscontacts.dao.InstantMessage im) {
        super(im.getId(), im.getContent(), im.getContactId(), im.getTagId());
    }

    protected InstantMessage(Parcel in) {
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

    public static final Creator<InstantMessage> CREATOR = new Creator<InstantMessage>() {
        public InstantMessage createFromParcel(Parcel source) {
            return new InstantMessage(source);
        }
        public InstantMessage[] newArray(int size) {
            return new InstantMessage[size];
        }
    };

}
