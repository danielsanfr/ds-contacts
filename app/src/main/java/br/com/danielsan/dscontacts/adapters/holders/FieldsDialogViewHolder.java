package br.com.danielsan.dscontacts.adapters.holders;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.danielsan.dscontacts.R;
import br.com.danielsan.dscontacts.managers.fields.edition.FieldEditionManager;

/**
 * Created by daniel on 10/01/16.
 */
public class FieldsDialogViewHolder extends ListViewHolder {

    private final TextView textView;

    public FieldsDialogViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fields_dialog, parent, false));
        textView = (TextView) itemView;
    }

    public void bind(FieldEditionManager fieldEditionManager) {
        textView.setText(fieldEditionManager.getFieldTitle());
        textView.setCompoundDrawablesWithIntrinsicBounds(fieldEditionManager.getFieldIcon(), 0, 0, 0);
    }

}
