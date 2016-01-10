package br.com.danielsan.dscontacts.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import br.com.danielsan.dscontacts.adapters.holders.FieldsDialogViewHolder;
import br.com.danielsan.dscontacts.managers.fields.edition.FieldEditionManager;

/**
 * Created by daniel on 10/01/16.
 */
public class FieldsAdapter extends BaseAdapter {

    private final ArrayList<FieldEditionManager> fieldEditionManagers;

    public FieldsAdapter(ArrayList<FieldEditionManager> fieldEditionManagers) {
        this.fieldEditionManagers = fieldEditionManagers;
    }

    @Override
    public int getCount() {
        return fieldEditionManagers.size();
    }

    @Override
    public FieldEditionManager getItem(int position) {
        return fieldEditionManagers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FieldsDialogViewHolder viewHolder;
        if (convertView == null)
            viewHolder = new FieldsDialogViewHolder(parent);
        else
            viewHolder = (FieldsDialogViewHolder) convertView.getTag();

        viewHolder.bind(fieldEditionManagers.get(position));
        return viewHolder.getItemView();
    }

}
