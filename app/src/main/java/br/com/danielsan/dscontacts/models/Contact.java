package br.com.danielsan.dscontacts.models;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import br.com.danielsan.dscontacts.dao.DaoSession;
import br.com.danielsan.dscontacts.dao.converters.BitmapPropertyConverter;

/**
 * Created by daniel on 18/01/16.
 */
public class Contact extends br.com.danielsan.dscontacts.dao.Contact implements Parcelable {

    public static final BitmapPropertyConverter BITMAP_PROPERTY_CONVERTER = new BitmapPropertyConverter();

    public Contact() { }

    public Contact(Long id) {
        super(id);
    }

    public Contact(Long id, Name name, boolean favorite, Bitmap picture, int color,
                   String organization, String title, Date createdAt) {
        super(id, name, favorite, picture, color, organization, title, createdAt);
    }

    public Contact(br.com.danielsan.dscontacts.dao.Contact contact) {
        super(contact.getId(), contact.getName(), contact.getFavorite(), contact.getPicture(),
              contact.getColor(), contact.getOrganization(), contact.getTitle(), contact.getCreatedAt());
    }

    protected Contact(Parcel in) {
        this.setId(in.readLong());
        this.setName(in.<Name>readParcelable(Name.class.getClassLoader()));
        this.setFavorite(in.readByte() != 0);

        byte[] picture = new byte[in.readInt()];
        in.readByteArray(picture);
        this.setPicture(BITMAP_PROPERTY_CONVERTER.convertToEntityProperty(picture));

        this.setColor(in.readInt());
        this.setOrganization(in.readString());
        this.setTitle(in.readString());
        this.setCreatedAt(new Date(in.readLong()));
    }

    public void setDaoSession(DaoSession daoSession) {
        this.__setDaoSession(daoSession);
    }

    @Override
    public int describeContents() {
        return 9;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.getId());
        dest.writeParcelable(this.getName(), flags);
        dest.writeByte(this.getFavorite() ? (byte) 1 : (byte) 0);

        byte[] picture = BITMAP_PROPERTY_CONVERTER.convertToDatabaseValue(this.getPicture());
        dest.writeInt(picture.length);
        dest.writeByteArray(picture);

        dest.writeInt(this.getColor());
        dest.writeString(this.getOrganization());
        dest.writeString(this.getTitle());
        dest.writeLong(this.getCreatedAt().getTime());
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }
        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

}
