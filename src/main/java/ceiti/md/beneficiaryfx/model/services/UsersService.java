package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Users;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements MyCrudRepository<Users> {
    @Override
    public List<Users> findAll() {
        return List.of();
    }

    @Override
    public Optional<Users> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Users save(Users entity) {
        return null;
    }

    @Override
    public void update(Users entity) {

    }

    @Override
    public void deleteById(int id) {

    }
}