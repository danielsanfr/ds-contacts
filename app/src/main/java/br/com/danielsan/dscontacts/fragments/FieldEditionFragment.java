package br.com.danielsan.dscontacts.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.danielsan.dscontacts.databinding.FragmentFieldEditionBaseBinding;
import br.com.danielsan.dscontacts.managers.fields.edition.FieldEditionManager;

/**
 * Created by daniel on 02/01/16.
 */
public class FieldEditionFragment extends BaseFragment {

    public static final String ARG_FIELD_EDITION_MANAGER = "field_edition_manager";

    private FragmentFieldEditionBaseBinding binding;
    protected FieldEditionManager fieldEditionManager;

    public static FieldEditionFragment newInstance(FieldEditionManager fieldEditionManager) {
        FieldEditionFragment fragment = new FieldEditionFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_FIELD_EDITION_MANAGER, fieldEditionManager);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = this.getArguments();
        if (args != null && args.containsKey(ARG_FIELD_EDITION_MANAGER))
            fieldEditionManager = args.getParcelable(ARG_FIELD_EDITION_MANAGER);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFieldEditionBaseBinding.inflate(inflater, container, false);
        fieldEditionManager.onCreateSubView(inflater, binding.lnrLytFields, savedInstanceState);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.txtVwFieldsTitle.setText(fieldEditionManager.getFieldTitle());
        binding.txtVwFieldsTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(fieldEditionManager.getFieldIcon(), 0, 0, 0);
    }

}
