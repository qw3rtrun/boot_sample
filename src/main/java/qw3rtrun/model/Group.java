package qw3rtrun.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Group {

    @Id
    private String name;

    @OneToMany(mappedBy = "group")
    private List<MyEntity> entities;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<MyEntity> getEntities() {
        return entities;
    }
}
