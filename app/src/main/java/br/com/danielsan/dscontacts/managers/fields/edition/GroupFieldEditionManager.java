package br.com.danielsan.dscontacts.managers.fields.edition;

import android.os.Bundle;
import android.os.Parcel;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.databinding.FieldEditionPictureBinding;

/**
 * Created by daniel on 03/01/16.
 */
public class GroupFieldEditionManager extends FieldEditionManager {

    private EditText editText;

    public GroupFieldEditionManager() {
        super(R.drawable.ic_people_gray_24dp, R.string.group);
    }

    protected GroupFieldEditionManager(Parcel in) {
        super(in);
    }

    @Override
    public void onCreateSubView(LayoutInflater inflater, LinearLayout fieldContainer, Bundle savedInstanceState) {
        editText = new EditText(fieldContainer.getContext());
        editText.setHint(R.string.group);
        fieldContainer.addView(editText);
    }

    public static final Creator<GroupFieldEditionManager> CREATOR = new Creator<GroupFieldEditionManager>() {
        @Override
        public GroupFieldEditionManager createFromParcel(Parcel in) {
            return new GroupFieldEditionManager(in);
        }
        @Override
        public GroupFieldEditionManager[] newArray(int size) {
            return new GroupFieldEditionManager[size];
        }
    };

}
