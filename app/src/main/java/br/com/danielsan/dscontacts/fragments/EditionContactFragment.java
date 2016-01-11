package br.com.danielsan.dscontacts.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.databinding.FragmentEditionContactBinding;
import br.com.danielsan.dscontacts.managers.fields.edition.AddressFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.EmailFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.EventFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.FieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.GroupFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.IMFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.NicknameFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.NoteFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.PhoneFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.PictureFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.RelationshipFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.WebsiteFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.WorkFieldEditionManager;

/**
 * Created by daniel on 03/01/16.
 */
public class EditionContactFragment extends BaseFragment {

    private static final String ARG_BTN_ADD_ORGANIZATION_VISIBILITY = "btn_add_organization_visibility";

    private FragmentEditionContactBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEditionContactBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null)
            this.restoreInstance(savedInstanceState);
        else
            this.addFragmentChild(R.id.frmLytGroupField, FieldEditionFragment.newInstance(new GroupFieldEditionManager()));

        binding.clasgToolbarLyt.setTitle(this.getText(R.string.app_name));
        binding.clasgToolbarLyt.setExpandedTitleColor(ContextCompat.getColor(this.getContext(), android.R.color.transparent));

        binding.toolbar.inflateMenu(R.menu.edition_contact);
        binding.toolbar.setOnMenuItemClickListener(onMenuItemClick);
        binding.toolbar.setNavigationIcon(R.drawable.ic_close_white_24dp);
        binding.toolbar.setNavigationOnClickListener(onClickClose);

        binding.btnAddOrganization.setOnClickListener(onClickAddOrganization);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_BTN_ADD_ORGANIZATION_VISIBILITY, binding.btnAddOrganization.getVisibility());
    }

    @SuppressWarnings("ResourceType")
    private void restoreInstance(Bundle savedInstanceState) {
        binding.btnAddOrganization.setVisibility(savedInstanceState.getInt(ARG_BTN_ADD_ORGANIZATION_VISIBILITY));
    }

    public void addFieldFragment(FieldEditionManager fieldEditionManager) {
        this.addFragmentChild(R.id.rootContent, FieldEditionFragment.newInstance(fieldEditionManager));
    }

    private final Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mn_favorite:
                    item.setChecked(!item.isChecked());
                    item.setIcon(item.isChecked() ? R.drawable.ic_star_white_24dp : R.drawable.ic_star_outline_white_24dp);
                    return true;
                default:
                    return false;
            }
        }
    };

    private final View.OnClickListener onClickClose = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getActivity().finish();
        }
    };

    private final View.OnClickListener onClickAddOrganization = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            view.setVisibility(View.GONE);
            addFragmentChild(R.id.frmLytWorkField,
                    FieldEditionFragment.newInstance(new WorkFieldEditionManager()));
        }
    };

    public static ArrayList<FieldEditionManager> createFieldEditionManagerList() {
        ArrayList<FieldEditionManager> fieldEditionManagers = new ArrayList<>();
        fieldEditionManagers.add(new PictureFieldEditionManager());
        fieldEditionManagers.add(new PhoneFieldEditionManager());
        fieldEditionManagers.add(new EmailFieldEditionManager());
        fieldEditionManagers.add(new IMFieldEditionManager());
        fieldEditionManagers.add(new NoteFieldEditionManager());
        fieldEditionManagers.add(new NicknameFieldEditionManager());
        fieldEditionManagers.add(new WebsiteFieldEditionManager());
        fieldEditionManagers.add(new EventFieldEditionManager());
        fieldEditionManagers.add(new AddressFieldEditionManager());
        fieldEditionManagers.add(new RelationshipFieldEditionManager());
        return fieldEditionManagers;
    }

}
