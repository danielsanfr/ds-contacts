package br.com.danielsan.dscontacts.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.fragments.FieldEditionFragment;
import br.com.danielsan.dscontacts.managers.fields.edition.FieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.NicknameFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.PhoneFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.PictureFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.WorkFieldEditionManager;
import br.com.ilhasoft.support.view.BaseActivity;

import br.com.danielsan.dscontacts.databinding.ActivityAddEditContactBinding;

/**
 * Created by daniel on 30/12/15.
 */
public class AddEditContactActivity extends BaseActivity {

    private ActivityAddEditContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_edit_contact);
        this.addFieldFragment(new WorkFieldEditionManager());
        this.addFieldFragment(new PictureFieldEditionManager());
        this.addFieldFragment(new PhoneFieldEditionManager());
        this.addFieldFragment(new NicknameFieldEditionManager());
    }

    private void addFieldFragment(FieldEditionManager fieldEditionManager) {
        this.getSupportFragmentManager().beginTransaction().add(R.id.rootContent, FieldEditionFragment.newInstance(fieldEditionManager)).commit();
    }

}
