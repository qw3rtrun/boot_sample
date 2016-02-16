package qw3rtrun;

import org.springframework.data.repository.CrudRepository;
import qw3rtrun.model.Attr;

public interface AttrRepository extends CrudRepository<Attr, Long> {

    Attr findByName(String name);
}
