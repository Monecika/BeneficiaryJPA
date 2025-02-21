package ceiti.md.beneficiaryfx.model.repositories;

import javafx.collections.ObservableList;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyCrudRepository<T> {
    ObservableList<T> findAll();
    Optional<T> findById(int id);
    void save(T entity);
    void update(T entity);
    void deleteById(T entity);
}
