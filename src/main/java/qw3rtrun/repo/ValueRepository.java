package qw3rtrun.repo;

import org.springframework.data.repository.CrudRepository;
import qw3rtrun.model.Value;

interface ValueRepository extends CrudRepository<Value, Value.PK> {

}
