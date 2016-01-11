package br.com.danielsan.dscontacts.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.adapters.FieldsAdapter;
import br.com.danielsan.dscontacts.fragments.EditionContactFragment;
import br.com.danielsan.dscontacts.managers.fields.edition.FieldEditionManager;

/**
 * Created by daniel on 03/01/16.
 */
public class EditionContactActivity extends BaseActivity {

    private static final String ARG_FIELD_EDITION_MANAGERS = "field_edition_mangers";

    private View fotnAtoBtn;
    private EditionContactFragment editionContactFrag;
    private ArrayList<FieldEditionManager> fieldEditionManagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.view_frame_layout);

        if (savedInstanceState == null)
            this.newInstance();
        else
            this.restoreInstance(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fotnAtoBtn = this.findViewById(R.id.fotnAtoBtn);
        if (fotnAtoBtn == null) {
            LayoutInflater.from(this).inflate(R.layout.view_floating_action_button, (ViewGroup) editionContactFrag.getView(), true);
            fotnAtoBtn = this.findViewById(R.id.fotnAtoBtn);
        }
        fotnAtoBtn.setOnClickListener(onClickAddField);
        this.checkEditionMangersSize();
    }

    private void newInstance() {
        editionContactFrag = new EditionContactFragment();
        this.addFragmentWithoutAnimation(R.id.rootContent, editionContactFrag);
        fieldEditionManagers = EditionContactFragment.createFieldEditionManagerList();
    }

    private void restoreInstance(Bundle savedInstanceState) {
        fieldEditionManagers = savedInstanceState.getParcelableArrayList(ARG_FIELD_EDITION_MANAGERS);
        editionContactFrag = (EditionContactFragment) this.getSupportFragmentManager().getFragments().get(0);
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

    private void checkEditionMangersSize() {
        if (fieldEditionManagers.isEmpty()) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) fotnAtoBtn.getLayoutParams();
            layoutParams.setBehavior(null);
            fotnAtoBtn.setLayoutParams(layoutParams);
            fotnAtoBtn.setVisibility(View.GONE);
        }
    }

    private final DialogInterface.OnClickListener onClickItemDialog = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            if (which >= 0)
                editionContactFrag.addFieldFragment(fieldEditionManagers.remove(which));
            checkEditionMangersSize();
        }
    };

    public final View.OnClickListener onClickAddField = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showAddFieldDialog();
        }
    };

}
