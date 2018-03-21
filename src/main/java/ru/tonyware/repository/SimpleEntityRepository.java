package ru.tonyware.repository;

import org.springframework.data.repository.CrudRepository;
import ru.tonyware.model.SimpleEntity;

public interface SimpleEntityRepository extends CrudRepository<SimpleEntity, Long> {
}
