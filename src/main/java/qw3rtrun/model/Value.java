package qw3rtrun.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Value implements Serializable {

    @Id
    @ManyToOne
    private MyEntity entity;

    @Id
    @ManyToOne
    private Attr attr;

    private String value;

    public MyEntity getEntity() {
        return entity;
    }

    public void setEntity(MyEntity entity) {
        this.entity = entity;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
