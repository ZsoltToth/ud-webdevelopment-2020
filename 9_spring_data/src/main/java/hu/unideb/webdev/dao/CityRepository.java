package hu.unideb.webdev.dao;

import hu.unideb.webdev.dao.entity.CityEntity;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<CityEntity, Integer> {
}
