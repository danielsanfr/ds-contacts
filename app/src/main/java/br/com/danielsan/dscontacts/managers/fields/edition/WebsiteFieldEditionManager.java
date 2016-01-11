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
public class WebsiteFieldEditionManager extends MultipleFieldEditionManager {

    public WebsiteFieldEditionManager() {
        super(R.drawable.ic_website_white_24dp, R.string.website);
    }

    protected WebsiteFieldEditionManager(Parcel in) {
        super(in);
    }

    protected boolean canAddSubView() {
        return true;
    }

    protected View getSubView(LayoutInflater inflater, ViewGroup container) {
        FieldEditionBasicBinding binding = FieldEditionBasicBinding.inflate(inflater, container, false);
        binding.edtTxtContent.setHint(R.string.website);
        return binding.getRoot();
    }

}
