package qw3rtrun.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(Value.PK.class)
public class Value implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private MyEntity entity;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Attr attr;

    public Value() {
    }

    public Value(MyEntity entity, Attr attr, String value) {
        this.entity = entity;
        this.attr = attr;
        this.value = value;
    }

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

    public static class PK implements Serializable {
        private Long entity;
        private Long attr;

        public PK() {
        }

        public PK(Long entity, Long attr) {
            this.entity = entity;
            this.attr = attr;
        }

        public Long getEntity() {
            return entity;
        }

        public Long getAttr() {
            return attr;
        }
    }
}
