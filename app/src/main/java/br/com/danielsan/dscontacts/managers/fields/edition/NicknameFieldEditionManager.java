package br.com.danielsan.dscontacts.managers.fields.edition;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.databinding.FieldEditionBasicBinding;

/**
 * Created by daniel on 03/01/16.
 */
public class NicknameFieldEditionManager extends MultipleFieldEditionManager {

    public NicknameFieldEditionManager() {
        super(R.drawable.ic_call_gray_24dp, R.string.nickname);
    }

    protected NicknameFieldEditionManager(Parcel in) {
        super(in);
    }

    protected boolean canAddSubView() {
        return true;
    }

    protected View getSubView(LayoutInflater inflater, ViewGroup container) {
        FieldEditionBasicBinding binding = FieldEditionBasicBinding.inflate(inflater, container, false);
        binding.edtTxtContent.setHint(R.string.nickname);
        return binding.getRoot();
    }

}
