package br.com.danielsan.dscontacts.dao.converters;

import br.com.danielsan.dscontacts.models.Name;
import de.greenrobot.dao.converter.PropertyConverter;

/**
 * Created by daniel on 10/01/16.
 */
public class NamePropertyConverter implements PropertyConverter<Name, String> {

    @Override
    public Name convertToEntityProperty(String databaseValue) {
        if (databaseValue == null)
            return null;

        return new Name(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(Name entityProperty) {
        if (entityProperty == null)
            return null;

        return entityProperty.toString();
    }

}
