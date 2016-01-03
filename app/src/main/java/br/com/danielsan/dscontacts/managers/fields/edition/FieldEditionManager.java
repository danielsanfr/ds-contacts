package br.com.danielsan.dscontacts.managers.fields.edition;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by daniel on 03/01/16.
 */
public abstract class FieldEditionManager implements Parcelable {

    @DrawableRes
    private final int fieldIcon;
    @StringRes
    private final int fieldTitle;

    protected FieldEditionManager(@DrawableRes int fieldIcon, @StringRes int fieldTitle) {
        this.fieldIcon = fieldIcon;
        this.fieldTitle = fieldTitle;
    }

    @DrawableRes
    public int getFieldIcon() {
        return fieldIcon;
    }

    @StringRes
    public int getFieldTitle() {
        return fieldTitle;
    }

    protected FieldEditionManager(Parcel in) {
        fieldIcon = in.readInt();
        fieldTitle = in.readInt();
    }

    @Override
    public int describeContents() {
        return 2;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(fieldIcon);
        dest.writeInt(fieldTitle);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof FieldEditionManager) {
            FieldEditionManager other = (FieldEditionManager) o;
            return (fieldIcon == other.fieldIcon && fieldTitle == other.fieldTitle);
        }

        return false;
    }

    public abstract void onCreateSubView(LayoutInflater inflater, LinearLayout fieldContainer, Bundle savedInstanceState);

}
