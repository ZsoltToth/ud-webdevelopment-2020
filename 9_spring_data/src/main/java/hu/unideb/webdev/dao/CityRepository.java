package hu.unideb.webdev.dao;

import hu.unideb.webdev.dao.entity.CityEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CityRepository extends CrudRepository<CityEntity, Integer> {

    Collection<CityEntity> findByName(String name);
}
