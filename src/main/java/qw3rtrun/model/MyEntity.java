package qw3rtrun.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class MyEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Version
    private Long version;

    @OneToMany(mappedBy = "entity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Value> values;

    public MyEntity() {
    }

    public MyEntity(long id, String name, Long version) {
        this.id = id;
        this.name = name;
        this.version = version;
    }

    public MyEntity(String name) {
        this.name = name;
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
        this.name = name;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version=" + version +
                '}';
    }


}
