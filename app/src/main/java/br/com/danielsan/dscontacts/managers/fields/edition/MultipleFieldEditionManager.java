package br.com.danielsan.dscontacts.managers.fields.edition;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import br.com.danielsan.dscontacts.R;

/**
 * Created by daniel on 03/01/16.
 */
public abstract class MultipleFieldEditionManager extends FieldEditionManager {

    private LayoutInflater inflater;
    private ViewGroup fieldContainer;

    protected MultipleFieldEditionManager(@DrawableRes int fieldIcon, @StringRes int fieldTitle) {
        super(fieldIcon, fieldTitle);
    }

    protected MultipleFieldEditionManager(Parcel in) {
        super(in);
    }

    @Override
    public final void onCreateSubView(LayoutInflater inflater, LinearLayout fieldContainer, Bundle savedInstanceState) {
        inflater.inflate(R.layout.view_flat_button_all_caps_start, fieldContainer, true);
        Button button = (Button) fieldContainer.getChildAt(0);
        button.setOnClickListener(onClickAddAnotherField);
        button.setText(R.string.add_another_field);
        button.setTextColor(ContextCompat.getColor(fieldContainer.getContext(), R.color.gray));
//        button.setVisibility(View.GONE);
        this.inflater = inflater;
        this.fieldContainer = fieldContainer;
    }

    public void addSubView() {
        if (this.canAddSubView()) {
            int childCount = fieldContainer.getChildCount();
            fieldContainer.addView(this.getSubView(inflater, fieldContainer), childCount - 1);
        }
    }

    protected abstract boolean canAddSubView();

    protected abstract View getSubView(LayoutInflater inflater, ViewGroup container);

    private final View.OnClickListener onClickAddAnotherField = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            addSubView();
        }
    };

}
