package qw3rtrun.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import qw3rtrun.DemoBootApplication;
import qw3rtrun.model.MyEntity;

import static java.lang.String.format;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.springframework.test.jdbc.JdbcTestUtils.countRowsInTableWhere;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoBootApplication.class)
@WebIntegrationTest
@Transactional
public class MyEntityRepositoryTest {

    @Autowired
    MyEntityRepository repository;

    @Autowired
    JdbcTemplate jdbc;

    @Test
    @Sql
    public void saveWithAttrsTest() {
    }

    @Test
    public void versionTest() {
        MyEntity entity = new MyEntity("test");
        entity = repository.save(entity);
        assertNotNull(entity.getId());
        assertThat(entity.getVersion(), equalTo(0L));

        assertEquals(countRowsInTableWhere(jdbc, "MY_ENTITY", format("name='%s' AND version=%d", entity.getName(), entity.getVersion())), 1);
    }

    @Test
    @Sql
    public void updateVersionTest() throws Exception {
        MyEntity entity = repository.findOne(1L);
        entity.setName("updatedName1");
        repository.count();

        assertEquals(countRowsInTableWhere(jdbc, "MY_ENTITY", format("name='%s' AND version=%d", "updatedName1", 2)), 1);
    }
}
