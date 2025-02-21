package ceiti.md.beneficiaryfx.model.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyCrudRepository<T> {
    List<T> findAll();
    Optional<T> findById(int id);
    T save(T entity);
    void update(T entity);
    void deleteById(int id);
}
