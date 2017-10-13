package qw3rtrun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import qw3rtrun.model.MyEntity;
import qw3rtrun.service.MyEntityService;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.boot.SpringApplication.run;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@SpringBootApplication
public class DemoBootApplication {
    public static void main(String[] args) {
        run(DemoBootApplication.class, args);
    }
}


@RestController
@RequestMapping("/")
class HelloRouter {
    @RequestMapping(method = GET)
    String get() {
        return "Hello!";
    }
}

@RestController
@RequestMapping("/ent")
class EntityRouter {

    @Autowired
    MyEntityService service;

    @RequestMapping(method = GET, value = "/{id}")
    MyEntity get(@PathVariable long id) {
        return service.get(id).get();
    }

    @RequestMapping(method = POST, value = "/{id}")
    MyEntity update(@PathVariable long id, @RequestBody String name) {
        return service.update(id, name).get();
    }

    @RequestMapping(method = PUT)
    MyEntity create(@RequestBody String name) {
        return service.create(name);
    }

    @RequestMapping(method = POST, consumes = "application/json")
    MyEntity replace(@RequestBody MyEntity entity) {
        return service.replace(entity);
    }

    @RequestMapping(method = GET)
    List<MyEntity> list() {
        return service.list();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void handle(NoSuchElementException e) {
        //nothing
    }
}
