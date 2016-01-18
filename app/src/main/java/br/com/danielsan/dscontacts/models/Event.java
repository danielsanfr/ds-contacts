package br.com.danielsan.dscontacts.models;

import android.os.Parcel;
import android.os.Parcelable;

import br.com.danielsan.dscontacts.dao.DaoSession;

/**
 * Created by daniel on 18/01/16.
 */
public class Event extends br.com.danielsan.dscontacts.dao.Event implements Parcelable {

    public Event() { }

    public Event(Long id) {
        super(id);
    }

    public Event(Long id, String content, long contactId, Long tagId) {
        super(id, content, contactId, tagId);
    }

    public Event(br.com.danielsan.dscontacts.dao.Event event) {
        super(event.getId(), event.getContent(), event.getContactId(), event.getTagId());
    }

    protected Event(Parcel in) {
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

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

}
