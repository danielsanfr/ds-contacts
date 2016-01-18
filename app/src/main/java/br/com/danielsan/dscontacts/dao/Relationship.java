package br.com.danielsan.dscontacts.dao;

import br.com.danielsan.dscontacts.dao.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "RELATIONSHIP".
 */
public class Relationship {

    private Long id;
    /** Not-null value. */
    private String content;
    private long contactId;
    private Long tagId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient RelationshipDao myDao;

    private Tag tag;
    private Long tag__resolvedKey;


    public Relationship() {
    }

    public Relationship(Long id) {
        this.id = id;
    }

    public Relationship(Long id, String content, long contactId, Long tagId) {
        this.id = id;
        this.content = content;
        this.contactId = contactId;
        this.tagId = tagId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRelationshipDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getContent() {
        return content;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setContent(String content) {
        this.content = content;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    /** To-one relationship, resolved on first access. */
    public Tag getTag() {
        Long __key = this.tagId;
        if (tag__resolvedKey == null || !tag__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TagDao targetDao = daoSession.getTagDao();
            Tag tagNew = targetDao.load(__key);
            synchronized (this) {
                tag = tagNew;
            	tag__resolvedKey = __key;
            }
        }
        return tag;
    }

    public void setTag(Tag tag) {
        synchronized (this) {
            this.tag = tag;
            tagId = tag == null ? null : tag.getId();
            tag__resolvedKey = tagId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
