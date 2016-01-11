package br.com.danielsan.dscontacts.managers.fields.edition;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.databinding.FieldEditionWithTagBinding;

/**
 * Created by daniel on 03/01/16.
 */
public class EventFieldEditionManager extends MultipleFieldEditionManager {

    public EventFieldEditionManager() {
        super(R.drawable.ic_event_gray_24dp, R.string.event);
    }

    protected EventFieldEditionManager(Parcel in) {
        super(in);
    }

    protected boolean canAddSubView() {
        return true;
    }

    protected View getSubView(LayoutInflater inflater, ViewGroup container) {
        FieldEditionWithTagBinding binding = FieldEditionWithTagBinding.inflate(inflater, container, false);
        binding.edtTxtContent.setHint(R.string.event);
        return binding.getRoot();
    }

}
