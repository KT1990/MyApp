package service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyModelRepository extends CrudRepository<MyModel,Integer> {

}
