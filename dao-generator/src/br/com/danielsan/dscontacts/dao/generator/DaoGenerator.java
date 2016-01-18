package br.com.danielsan.dscontacts.dao.generator;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class DaoGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "br.com.danielsan.dscontacts.dao");
        Entity contact = DaoGenerator.addContact(schema);
        Entity tag = DaoGenerator.addTag(schema);
//        DaoGenerator.addGroup(schema, contact);
        DaoGenerator.addSimpleField(schema, contact, "Nickname");
        DaoGenerator.addSimpleField(schema, contact, "Note");
        DaoGenerator.addSimpleField(schema, contact, "Website");
        DaoGenerator.addWithTagField(schema, contact, tag, "Address");
        DaoGenerator.addWithTagField(schema, contact, tag, "Email");
        DaoGenerator.addWithTagField(schema, contact, tag, "Event");
        DaoGenerator.addWithTagField(schema, contact, tag, "InstantMessage");
        DaoGenerator.addWithTagField(schema, contact, tag, "Phone");
        DaoGenerator.addWithTagField(schema, contact, tag, "Relationship");

        new de.greenrobot.daogenerator.DaoGenerator().generateAll(schema, "app/src/main/java");
    }

    private static Entity addContact(Schema schema) {
        Entity contact = schema.addEntity("Contact");
        contact.addIdProperty();
        contact.addStringProperty("name").notNull().customType("br.com.danielsan.dscontacts.dao.Name",
                                                               "br.com.danielsan.dscontacts.dao.converters.NamePropertyConverter");
        contact.addBooleanProperty("favorite").notNull();
        contact.addByteArrayProperty("picture").customType("android.graphics.Bitmap",
                                                           "br.com.danielsan.dscontacts.dao.converters.BitmapPropertyConverter");
        contact.addIntProperty("color").notNull();
        contact.addStringProperty("organization");
        contact.addStringProperty("title");
        contact.addDateProperty("createdAt").notNull();

        return contact;
    }

    private static Entity addSimpleField(Schema schema, Entity contact, String entityName) {
        Entity entity = schema.addEntity(entityName);
        entity.addIdProperty();
        entity.addStringProperty("content").notNull();

        DaoGenerator.addToManyContact(contact, entity);
        return entity;
    }

    private static Entity addWithTagField(Schema schema, Entity contact, Entity tag, String entityName) {
        Entity entity = DaoGenerator.addSimpleField(schema, contact, entityName);
        entity.addToOne(tag, entity.addLongProperty("tagId").getProperty());
        return entity;
    }

    private static void addGroup(Schema schema, Entity contact) {
        Entity group = schema.addEntity("Group");
        group.addIdProperty();
        group.addStringProperty("name").notNull();

        DaoGenerator.addToManyContact(contact, group);
    }

    private static Entity addTag(Schema schema) {
        Entity tag = schema.addEntity("Tag");
        tag.addIdProperty();
        tag.addStringProperty("text").notNull();
        tag.addStringProperty("fieldName").notNull();

        return tag;
    }

    private static void addToManyContact(Entity contact, Entity entity) {
        contact.addToMany(entity, entity.addLongProperty("contactId").notNull().getProperty());
    }

}