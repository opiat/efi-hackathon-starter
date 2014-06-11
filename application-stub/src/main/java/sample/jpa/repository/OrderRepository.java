package sample.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sample.jpa.model.SomethingToPersit;

@Repository
public interface OrderRepository extends CrudRepository<SomethingToPersit, Long>{

}
