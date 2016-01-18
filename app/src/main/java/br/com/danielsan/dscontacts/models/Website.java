package br.com.danielsan.dscontacts.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by daniel on 18/01/16.
 */
public class Website extends br.com.danielsan.dscontacts.dao.Website implements Parcelable {

    public Website() { }

    public Website(Long id) {
        super(id);
    }

    public Website(Long id, String content, long contactId) {
        super(id, content, contactId);
    }

    public Website(br.com.danielsan.dscontacts.dao.Website website) {
        super(website.getId(), website.getContent(), website.getContactId());
    }

    protected Website(Parcel in) {
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

    public static final Creator<Website> CREATOR = new Creator<Website>() {
        public Website createFromParcel(Parcel source) {
            return new Website(source);
        }
        public Website[] newArray(int size) {
            return new Website[size];
        }
    };

}
