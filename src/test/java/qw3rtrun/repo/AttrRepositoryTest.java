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
import qw3rtrun.model.Attr;

import static java.lang.String.format;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.*;
import static org.springframework.test.jdbc.JdbcTestUtils.countRowsInTableWhere;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoBootApplication.class)
@WebIntegrationTest
@Transactional
public class AttrRepositoryTest {

    @Autowired
    AttrRepository repository;

    @Autowired
    JdbcTemplate jdbc;

    @Test
    @Sql
    public void findAttrTest() throws Exception {
        assertThat(repository.findOne(1L), samePropertyValuesAs(new Attr(1, "length")));
        assertThat(repository.findOne(2L), samePropertyValuesAs(new Attr(2, "width")));
    }

    @Test
    public void saveTest() throws Exception {
        Attr attr1 = repository.save(new Attr("length"));
        Attr attr2 = repository.save(new Attr("width"));

        assertEquals(countRowsInTableWhere(jdbc, "ATTR", format("id=%s AND name='length'", attr1.getId())), 1);
        assertEquals(countRowsInTableWhere(jdbc, "ATTR", format("id=%s AND name='width'", attr2.getId())), 1);
    }

    @Test
    @Sql
    public void findByNameTest() throws Exception {
        assertTrue(repository.findByName("width").isPresent());
        assertTrue(repository.findByName("length").isPresent());
        assertFalse(repository.findByName("height").isPresent());
        assertThat(repository.findByName("width").get(), samePropertyValuesAs(new Attr(2, "width")));
        assertThat(repository.findByName("length").get(), samePropertyValuesAs(new Attr(1, "length")));
    }

}
