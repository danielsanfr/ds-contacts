package br.com.danielsan.dscontacts.dao.converters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

import de.greenrobot.dao.converter.PropertyConverter;

/**
 * Created by daniel on 10/01/16.
 */
public class BitmapPropertyConverter implements PropertyConverter<Bitmap, byte[]> {

    @Override
    public Bitmap convertToEntityProperty(byte[] databaseValue) {
        if (databaseValue == null)
            return null;
        return BitmapFactory.decodeByteArray(databaseValue, 0, databaseValue.length);
    }

    @Override
    public byte[] convertToDatabaseValue(Bitmap entityProperty) {
        if (entityProperty == null)
            return null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        entityProperty.compress(Bitmap.CompressFormat.JPEG, 100, bos);
        return bos.toByteArray();
    }

}
