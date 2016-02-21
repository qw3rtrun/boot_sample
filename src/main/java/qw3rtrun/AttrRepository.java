package qw3rtrun;

import org.springframework.data.repository.CrudRepository;
import qw3rtrun.model.Attr;

import java.util.Optional;

public interface AttrRepository extends CrudRepository<Attr, Long> {

    Optional<Attr> findByName(String name);
}
