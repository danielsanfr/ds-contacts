package br.com.danielsan.dscontacts.adapters.holders;

import android.content.Context;
import android.view.View;

/**
 * Created by daniel on 10/01/16.
 */
public abstract class ListViewHolder {

    protected final View itemView;

    public ListViewHolder(View itemView) {
        this.itemView = itemView;
        itemView.setTag(this);
    }

    public View getItemView() {
        return itemView;
    }

    public Context getContext() {
        return itemView.getContext();
    }

}
