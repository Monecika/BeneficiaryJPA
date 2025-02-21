package ceiti.md.beneficiaryfx.model.repositories;

import ceiti.md.beneficiaryfx.model.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
}
