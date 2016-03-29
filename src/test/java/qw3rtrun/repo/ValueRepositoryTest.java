package qw3rtrun.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import qw3rtrun.DemoBootApplication;
import qw3rtrun.model.Attr;
import qw3rtrun.model.Group;
import qw3rtrun.model.MyEntity;
import qw3rtrun.model.Value;

import static java.lang.String.format;
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoBootApplication.class)
@WebIntegrationTest
@Transactional
public class ValueRepositoryTest {

    @Autowired
    ValueRepository repository;

    @Autowired
    AttrRepository attrRepo;

    @Autowired
    MyEntityRepository entRepo;

    @Autowired
    GroupRepository groupRepo;

    @Test
    public void saveTest() throws Exception {
        Value v1 = repository.save(new Value(new MyEntity("ent_1", new Group("group")), new Attr("length"), "val1"));
        assertEquals(1L, repository.count());
    }

    @Test
    public void groupTest() {

    }

}
