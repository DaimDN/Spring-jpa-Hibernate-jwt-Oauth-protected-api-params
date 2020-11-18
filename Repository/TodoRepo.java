package microservices.Spring.Repository;

import microservices.Spring.Database.Access;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TodoRepo extends CrudRepository<Access, Integer> {

    @Override
    Iterable<Access> findAllById(Iterable<Integer> iterable);

    String getPassword();

    String getName(String email);
}
