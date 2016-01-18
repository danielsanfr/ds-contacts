package br.com.danielsan.dscontacts.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by daniel on 18/01/16.
 */
public class Note extends br.com.danielsan.dscontacts.dao.Note implements Parcelable {

    public Note() { }

    public Note(Long id) {
        super(id);
    }

    public Note(Long id, String content, long contactId) {
        super(id, content, contactId);
    }

    public Note(br.com.danielsan.dscontacts.dao.Note note) {
        super(note.getId(), note.getContent(), note.getContactId());
    }

    protected Note(Parcel in) {
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

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        public Note createFromParcel(Parcel source) {
            return new Note(source);
        }
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

}
