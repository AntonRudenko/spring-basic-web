package ru.tonyware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.tonyware.model.SimpleEntity;
import ru.tonyware.repository.SimpleEntityRepository;

@RestController
@RequestMapping("simpleEntity")
public class SimpleEntityController {

    @Autowired
    private SimpleEntityRepository simpleEntityRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<SimpleEntity> getAll() {
        return simpleEntityRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public SimpleEntity create(@RequestBody SimpleEntity simpleEntity) {
        return simpleEntityRepository.save(simpleEntity);
    }

}
