package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Cards;
import ceiti.md.beneficiaryfx.model.repositories.CardsRepository;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardsService implements MyCrudRepository<Cards> {
    private final CardsRepository cardsRepository;

    @Autowired
    public CardsService(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @Override
    public ObservableList<Cards> findAll() {
        List<Cards> cardsList = cardsRepository.findAll();
        return FXCollections.observableArrayList(cardsList);
    }

    @Override
    public Optional<Cards> findById(int id) {
        return cardsRepository.findById(id);
    }

    @Override
    public void save(Cards entity) {
        cardsRepository.save(entity);
    }

    @Override
    public void update(Cards entity) {
        cardsRepository.save(entity);
    }

    @Override
    public void deleteById(Cards entity) {
        cardsRepository.delete(entity);
    }

    // Custom method to find a card by its card number
    public Cards getCard(String cardNumber) {
        return cardsRepository.findByCardNr(cardNumber)
                              .orElse(null);
    }
}
