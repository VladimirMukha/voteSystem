package model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@MappedSuperclass
public abstract class BaseModel {
    public static final int START_SEQ = 0;

@Id
@Access(AccessType.PROPERTY)
    private Integer id;

    protected BaseModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return id != null;
    }
}