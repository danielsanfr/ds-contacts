package br.com.danielsan.dscontacts.managers.fields.edition;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.databinding.FieldEditionWorkBinding;

/**
 * Created by daniel on 03/01/16.
 */
public class WorkFieldEditionManager extends FieldEditionManager {

    public WorkFieldEditionManager() {
        super(R.drawable.ic_work_gray_24dp, R.string.work);
    }

    protected WorkFieldEditionManager(Parcel in) {
        super(in);
    }

    @Override
    public void onCreateSubView(LayoutInflater inflater, LinearLayout fieldContainer, Bundle savedInstanceState) {
        fieldContainer.setOrientation(LinearLayout.HORIZONTAL);
        fieldContainer.setBaselineAligned(false);
        FieldEditionWorkBinding binding = FieldEditionWorkBinding.inflate(inflater, fieldContainer, true);
    }

    public static final Creator<WorkFieldEditionManager> CREATOR = new Creator<WorkFieldEditionManager>() {
        @Override
        public WorkFieldEditionManager createFromParcel(Parcel in) {
            return new WorkFieldEditionManager(in);
        }
        @Override
        public WorkFieldEditionManager[] newArray(int size) {
            return new WorkFieldEditionManager[size];
        }
    };

}
