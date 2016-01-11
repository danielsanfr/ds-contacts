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
public class IMFieldEditionManager extends MultipleFieldEditionManager {

    public IMFieldEditionManager() {
        super(R.drawable.ic_message_gray_24dp, R.string.im);
    }

    protected IMFieldEditionManager(Parcel in) {
        super(in);
    }

    protected boolean canAddSubView() {
        return true;
    }

    protected View getSubView(LayoutInflater inflater, ViewGroup container) {
        FieldEditionWithTagBinding binding = FieldEditionWithTagBinding.inflate(inflater, container, false);
        binding.edtTxtContent.setHint(R.string.im);
        return binding.getRoot();
    }

}
