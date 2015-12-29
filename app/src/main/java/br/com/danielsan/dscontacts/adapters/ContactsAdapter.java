package br.com.danielsan.dscontacts.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.danielsan.dscontacts.adapters.holders.ContactsViewHolder;

/**
 * Created by daniel on 29/12/15.
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsViewHolder> {

    public ContactsAdapter() {
        this.setHasStableIds(true);
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactsViewHolder(new TextView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {
        ((TextView) holder.itemView).setText("Daniel San Ferreira da Rocha");
    }

    @Override
    public int getItemCount() {
        return 50;
    }

}
