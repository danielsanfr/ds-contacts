package br.com.danielsan.dscontacts.activities;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;

import java.util.ArrayList;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.databinding.ActivityEditionContactBinding;
import br.com.danielsan.dscontacts.managers.fields.edition.FieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.NicknameFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.PhoneFieldEditionManager;
import br.com.ilhasoft.support.view.BaseActivity;

/**
 * Created by daniel on 03/01/16.
 */
public class EditionContactActivity extends BaseActivity {

    private static final String ARG_FIELD_EDITION_MANAGERS = "field_edition_mangers";

    private ActivityEditionContactBinding binding;
    private ArrayList<FieldEditionManager> fieldEditionManagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edition_contact);
        binding.fotnAtoBtn.setOnClickListener(onClickAddField);
        if (savedInstanceState == null)
            fieldEditionManagers = EditionContactActivity.createFieldEditionManagerList();
        else
            fieldEditionManagers = savedInstanceState.getParcelableArrayList(ARG_FIELD_EDITION_MANAGERS);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(ARG_FIELD_EDITION_MANAGERS, fieldEditionManagers);
    }

    private void showAddFieldDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.add_field);
        builder.setItems(new CharSequence[]{"Daniel", "Erika"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
//        builder.setSingleChoiceItems(new FieldsAdapter(fieldEditionManagers), -1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//            }
//        });
        builder.show();
    }

    public final View.OnClickListener onClickAddField = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showAddFieldDialog();
        }
    };

    private static ArrayList<FieldEditionManager> createFieldEditionManagerList() {
        ArrayList<FieldEditionManager> fieldEditionManagers = new ArrayList<>();
        fieldEditionManagers.add(new PhoneFieldEditionManager());
        fieldEditionManagers.add(new NicknameFieldEditionManager());
        return fieldEditionManagers;
    }

}
