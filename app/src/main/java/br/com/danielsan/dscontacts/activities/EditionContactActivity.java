package br.com.danielsan.dscontacts.activities;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.adapters.FieldsAdapter;
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

    private MenuItem mnfavorite;
    private ActivityEditionContactBinding binding;
    private ArrayList<FieldEditionManager> fieldEditionManagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edition_contact);

        this.setSupportActionBar(binding.toolbar);
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_close_white_24dp);
        }

        binding.clasgToolbarLyt.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));
        binding.fotnAtoBtn.setOnClickListener(onClickAddField);

        if (savedInstanceState == null)
            fieldEditionManagers = EditionContactActivity.createFieldEditionManagerList();
        else
            fieldEditionManagers = savedInstanceState.getParcelableArrayList(ARG_FIELD_EDITION_MANAGERS);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.edition_contact, menu);
        mnfavorite = menu.findItem(R.id.mn_favorite);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mn_favorite:
                item.setChecked(!item.isChecked());
                item.setIcon(item.isChecked() ? R.drawable.ic_star_white_24dp : R.drawable.ic_star_outline_white_24dp);
                return true;
            case android.R.id.home:
                this.finish();
            default:
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(ARG_FIELD_EDITION_MANAGERS, fieldEditionManagers);
    }

    private void showAddFieldDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.add_field);
        builder.setSingleChoiceItems(new FieldsAdapter(fieldEditionManagers), -1, onClickItemDialog);
        builder.show();
    }

    private final DialogInterface.OnClickListener onClickItemDialog = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    };

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
