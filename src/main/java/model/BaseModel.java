package model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class BaseModel {
    public static final int START_SEQ = 0;
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