package br.com.danielsan.dscontacts.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import br.com.danielsan.dscontacts.databinding.FragmentNameFieldEditionBinding;
import br.com.danielsan.dscontacts.models.Name;
import br.com.ilhasoft.support.view.SimpleTextWatcher;

/**
 * Created by daniel on 10/01/16.
 */
public class NameFieldEditionFragment extends BaseFragment {

    private Name name;
    private boolean shouldUpdate;
    private FragmentNameFieldEditionBinding binding;
    private OnNameChangedListener onNameChangedListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        name = new Name();
        shouldUpdate = true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNameFieldEditionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.imgBtnExpand.setOnClickListener(onClickExpand);
        binding.edtTxtName.addTextChangedListener(textWatcherName);
        binding.edtTxtFirstName.addTextChangedListener(textWatcherParts);
        binding.edtTxtMiddleName.addTextChangedListener(textWatcherParts);
        binding.edtTxtLastName.addTextChangedListener(textWatcherParts);
    }

    public void setOnNameChangedListener(OnNameChangedListener onNameChangedListener) {
        this.onNameChangedListener = onNameChangedListener;
    }

    private void toggleNamesVisibility() {
        if (binding.txtIptLytName.getVisibility() == View.VISIBLE) {
            binding.imgBtnExpand.setRotation(180f);
            binding.txtIptLytFirstName.setVisibility(View.VISIBLE);
            binding.txtIptLytMiddleName.setVisibility(View.VISIBLE);
            binding.txtIptLytLastName.setVisibility(View.VISIBLE);
            binding.txtIptLytName.setVisibility(View.GONE);

            shouldUpdate = false;
            name.setName(this.getTrimmedString(binding.edtTxtName));
            binding.edtTxtFirstName.setText(name.getFirstName());
            binding.edtTxtMiddleName.setText(name.getMiddleName());
            binding.edtTxtLastName.setText(name.getLastName());
            shouldUpdate = true;
        } else {
            binding.imgBtnExpand.setRotation(0);
            binding.txtIptLytName.setVisibility(View.VISIBLE);
            binding.txtIptLytFirstName.setVisibility(View.GONE);
            binding.txtIptLytMiddleName.setVisibility(View.GONE);
            binding.txtIptLytLastName.setVisibility(View.GONE);

            shouldUpdate = false;
            name.setName(this.getTrimmedString(binding.edtTxtFirstName),
                         this.getTrimmedString(binding.edtTxtMiddleName),
                         this.getTrimmedString(binding.edtTxtLastName));
            binding.edtTxtName.setText(name.getName());
            shouldUpdate = true;
        }
    }

    private void dispatchOnNameChanged() {
        if (onNameChangedListener != null) {
            onNameChangedListener.onNameChanged(name.getName());
        }
    }

    private String getTrimmedString(EditText editText) {
        return editText.getText().toString().trim();
    }

    private final SimpleTextWatcher textWatcherName = new SimpleTextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            super.onTextChanged(s, start, before, count);
            if (shouldUpdate) {
                name.setName(s.toString());
                dispatchOnNameChanged();
            }
        }
    };

    private final SimpleTextWatcher textWatcherParts = new SimpleTextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            super.onTextChanged(s, start, before, count);
            if (shouldUpdate) {
                name.setName(getTrimmedString(binding.edtTxtFirstName),
                             getTrimmedString(binding.edtTxtMiddleName),
                             getTrimmedString(binding.edtTxtLastName));
                dispatchOnNameChanged();
            }
        }
    };

    private final View.OnClickListener onClickExpand = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            toggleNamesVisibility();
        }
    };

    public interface OnNameChangedListener {
        void onNameChanged(CharSequence name);
    }

}
