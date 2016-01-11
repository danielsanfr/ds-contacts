package br.com.danielsan.dscontacts.models.serializers;

import br.com.danielsan.dscontacts.models.Name;

/**
 * Created by daniel on 10/01/16.
 */
public class NameSerializer {

//    @Override
    public Class<?> getDeserializedType() {
        return Name.class;
    }

//    @Override
    public Class<?> getSerializedType() {
        return String.class;
    }

//    @Override
    public String serialize(Object data) {
        if (data == null || !(data instanceof Name))
            return "";
        else
            return ((Name) data).getName();
    }

//    @Override
    public Name deserialize(Object data) {
        if (data == null || !(data instanceof String))
            return new Name();
        else
            return new Name(data.toString());
    }

}
