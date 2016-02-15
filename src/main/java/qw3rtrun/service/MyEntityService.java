package qw3rtrun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qw3rtrun.model.MyEntity;
import qw3rtrun.repo.MyEntityRepository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Service
@Transactional
public class MyEntityService {

    @Autowired
    private MyEntityRepository repo;

    public MyEntity create(String name) {
        return repo.save(new MyEntity(name, 0L));
    }

    public Optional<MyEntity> get(long id) {
        return Optional.ofNullable(repo.findOne(id));
    }

    public Optional<MyEntity> update(long id, String name) {
        Optional<MyEntity> entity = Optional.ofNullable(repo.findOne(id));
        entity.ifPresent(e -> {
            e.setName(name);
            e.setVersion(e.getVersion() + 1);
        });
        return entity;
    }

    public MyEntity replace(MyEntity entity) {
        return repo.save(entity);

    }

    public List<MyEntity> list() {
        return stream(repo.findAll().spliterator(), false).collect(toList());
    }
}
