package br.com.danielsan.dscontacts.managers.fields.edition;

import android.os.Bundle;
import android.os.Parcel;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.databinding.FieldEditionPictureBinding;
import br.com.danielsan.dscontacts.databinding.FieldEditionWorkBinding;

/**
 * Created by daniel on 03/01/16.
 */
public class PictureFieldEditionManager extends FieldEditionManager {

    public PictureFieldEditionManager() {
        super(R.drawable.ic_picture_gray_24dp, R.string.picture);
    }

    protected PictureFieldEditionManager(Parcel in) {
        super(in);
    }

    @Override
    public void onCreateSubView(LayoutInflater inflater, LinearLayout fieldContainer, Bundle savedInstanceState) {
        fieldContainer.setOrientation(LinearLayout.HORIZONTAL);
        fieldContainer.setGravity(Gravity.CENTER_VERTICAL);
        FieldEditionPictureBinding binding = FieldEditionPictureBinding.inflate(inflater, fieldContainer, true);
    }

    public static final Creator<PictureFieldEditionManager> CREATOR = new Creator<PictureFieldEditionManager>() {
        @Override
        public PictureFieldEditionManager createFromParcel(Parcel in) {
            return new PictureFieldEditionManager(in);
        }
        @Override
        public PictureFieldEditionManager[] newArray(int size) {
            return new PictureFieldEditionManager[size];
        }
    };

}
