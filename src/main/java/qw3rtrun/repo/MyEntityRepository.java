package qw3rtrun.repo;

import org.springframework.data.repository.CrudRepository;
import qw3rtrun.model.MyEntity;

public interface MyEntityRepository extends CrudRepository<MyEntity, Long> {
}
