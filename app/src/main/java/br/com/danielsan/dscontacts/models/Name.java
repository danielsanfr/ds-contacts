package br.com.danielsan.dscontacts.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by daniel on 10/01/16.
 */
public class Name implements Parcelable {

    private String name = "";
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";

    public Name() { }

    public Name(String name) {
        this.setNameInternal(name);
    }

    public Name(String firstName, String middleName, String lastName) {
        this.setNameInternal(firstName, middleName, lastName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!this.name.equals(name))
            this.setNameInternal(name);
    }

    public void setName(String firstName, String middleName, String lastName) {
        if (!name.equals(String.format("%s %s %s", firstName, middleName, lastName)))
            this.setNameInternal(firstName, middleName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!this.firstName.equals(firstName)) {
            ArrayList<String> parts = this.getParts(firstName);
            parts.addAll(Arrays.asList(middleName.split(" ")));
            parts.add(lastName);
            this.setNameInternal(parts);
        }
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        if (!this.middleName.equals(middleName)) {
            ArrayList<String> parts = this.getParts(middleName);
            parts.add(0, firstName);
            parts.add(lastName);
            this.setNameInternal(parts);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!this.lastName.equals(lastName)) {
            ArrayList<String> parts = this.getParts(lastName);
            parts.add(0, middleName);
            parts.add(0, firstName);
            this.setNameInternal(parts);
        }
    }

    public boolean isEmpty() {
        return name.isEmpty();
    }

    @Override
    public String toString() {
        return name;
    }

    private ArrayList<String> getParts(String... parts) {
        ArrayList<String> list = new ArrayList<>();
        for (String a : parts) {
            String[] b = a.trim().split(" ");
            for (String c : b) {
                String d = c.trim();
                if (!d.isEmpty())
                    list.add(d);
            }
        }
        return list;
    }

    private void setNameInternal(String... parts) {
        this.setNameInternal(this.getParts(parts));
    }

    private void setNameInternal(ArrayList<String> pars) {
        name = "";
        firstName = "";
        middleName = "";
        lastName = "";

        int size = pars.size();
        if (size == 0)
            return;

        firstName = pars.get(0);
        if (size == 2)
            lastName = pars.get(1);
        else if (size > 2) {
            lastName = pars.get(size - 1);
            String middleName = "";
            for (int i = 1, length = size - 1; i < length; i++) {
                middleName += pars.get(i) + " ";
                this.middleName = middleName.trim();
            }
        }

        this.updateName();
    }

    private void updateName() {
        String name = firstName;
        name += " " + middleName;
        name = name.trim();
        name += " " +  lastName;

        this.name = name.trim();
    }

    @Override
    public int describeContents() {
        return 4;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.firstName);
        dest.writeString(this.middleName);
        dest.writeString(this.lastName);
    }

    protected Name(Parcel in) {
        this.name = in.readString();
        this.firstName = in.readString();
        this.middleName = in.readString();
        this.lastName = in.readString();
    }

    public static final Parcelable.Creator<Name> CREATOR = new Parcelable.Creator<Name>() {
        public Name createFromParcel(Parcel source) {
            return new Name(source);
        }
        public Name[] newArray(int size) {
            return new Name[size];
        }
    };

}
