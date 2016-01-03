package br.com.danielsan.dscontacts.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.databinding.FragmentEditionContactBinding;
import br.com.danielsan.dscontacts.managers.fields.edition.FieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.NicknameFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.PhoneFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.PictureFieldEditionManager;
import br.com.danielsan.dscontacts.managers.fields.edition.WorkFieldEditionManager;
import br.com.ilhasoft.support.view.BaseFragment;

/**
 * Created by daniel on 03/01/16.
 */
public class EditionContactFragment extends BaseFragment {

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
        binding.btnAddOrganization.setOnClickListener(onClickAddOrganization);
    }

    private void addFieldFragment(FieldEditionManager fieldEditionManager) {
        this.getChildFragmentManager().beginTransaction().add(R.id.rootContent, FieldEditionFragment.newInstance(fieldEditionManager)).commit();
    }

    private final View.OnClickListener onClickAddOrganization = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            view.setVisibility(View.GONE);
            addFieldFragment(new WorkFieldEditionManager());
        }
    };

}
