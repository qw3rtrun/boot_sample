package qw3rtrun.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
public class Attr implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name = "";

    Attr() {
    }

    public Attr(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Attr(String name) {
        setName(name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) throw new NullPointerException("Name of Arrt can not be null");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Attr{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
