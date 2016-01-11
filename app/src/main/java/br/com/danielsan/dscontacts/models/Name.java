package br.com.danielsan.dscontacts.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by daniel on 10/01/16.
 */
public class Name implements Parcelable {

    private String name = "";
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";
    private boolean shouldUpdateName = false;
    private boolean shouldUpdateParts = false;

    public Name() {
        shouldUpdateName = true;
        shouldUpdateParts = true;
    }

    public Name(String name) {
        this.setName(name);
        shouldUpdateName = true;
        shouldUpdateParts = true;
        this.updateParts();

    }

    public Name(String firstName, String middleName, String lastName) {
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        shouldUpdateName = true;
        shouldUpdateParts = true;
        this.updateName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
        this.updateParts();
    }
    public void setName(String firstName, String middleName, String lastName) {
        this.firstName = firstName.trim();
        this.middleName = middleName.trim();
        this.lastName = lastName.trim();
        this.updateName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
        this.updateName();
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName.trim();
        this.updateName();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
        this.updateName();
    }

    public boolean isEmpty() {
        return name.isEmpty();
    }

    private void updateName() {
        if (!shouldUpdateName)
            return;

        String name = firstName;
        name += " " + middleName;
        name = name.trim();
        name += " " +  lastName;

        this.name = name.trim();
    }

    private void updateParts() {
        if (!shouldUpdateParts)
            return;

        String[] names = name.split(" ");
        int length = names.length;
        if (length > 0) {
            firstName = names[0];
            if (length == 2)
                middleName = names[1];
            else if (length > 2) {
                lastName = names[length - 1];
                String middleName = "";
                for (int i = 1; i < length - 1; i++) {
                    middleName += names[i] + " ";
                    this.middleName = middleName.trim();
                }
            }
        }
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
        shouldUpdateName = true;
        shouldUpdateParts = true;
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
