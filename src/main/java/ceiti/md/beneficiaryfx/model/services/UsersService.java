package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Users;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import ceiti.md.beneficiaryfx.model.repositories.UsersRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements MyCrudRepository<Users> {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public ObservableList<Users> findAll() {
        List<Users> usersList = usersRepository.findAll();
        return FXCollections.observableArrayList(usersList);
    }

    @Override
    public Optional<Users> findById(int id) {
        return usersRepository.findById(id);
    }

    @Override
    public void save(Users entity) {
        usersRepository.save(entity);
    }

    @Override
    public void update(Users entity) {
        usersRepository.save(entity);
    }

    @Override
    public void deleteById(Users entity) {
        usersRepository.delete(entity);
    }
}
