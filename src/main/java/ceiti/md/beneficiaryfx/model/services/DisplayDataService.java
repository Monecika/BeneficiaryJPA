package ceiti.md.beneficiaryfx.model.services;

import ceiti.md.beneficiaryfx.model.entities.Beneficiaries;
import ceiti.md.beneficiaryfx.model.entities.Cards;
import ceiti.md.beneficiaryfx.model.entities.DisplayData;
import ceiti.md.beneficiaryfx.model.entities.Localities;
import ceiti.md.beneficiaryfx.model.repositories.MyCrudRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisplayDataService implements MyCrudRepository<DisplayData> {
    private final BeneficiariesService beneficiariesService;
    private final CardsService cardsService;
    private final LocalitiesService localitiesService;

    @Autowired
    public DisplayDataService(BeneficiariesService beneficiariesService, CardsService cardsService,
                              LocalitiesService localitiesService) {
        this.beneficiariesService = beneficiariesService;
        this.cardsService = cardsService;
        this.localitiesService = localitiesService;
    }


    @Override
    public ObservableList<DisplayData> findAll() {
        ObservableList<DisplayData> displayDataList = FXCollections.observableArrayList();
        ObservableList<Beneficiaries> beneficiariesList = beneficiariesService.findAll();

        DisplayData displayData;
        Beneficiaries beneficiaries;
        Localities localities;
        Cards cards;

        while (!beneficiariesList.isEmpty()) {
            beneficiaries = beneficiariesList.getFirst();
            int id = beneficiaries.getID();
            String benID = beneficiaries.getCodeBen();
            String name = beneficiaries.getNameBen();
            String surname = beneficiaries.getSurnameBen();
            String phone = beneficiaries.getPhoneBen();
            String idnp = beneficiaries.getIDNP();
            String address = beneficiaries.getAddressBen();
            String email = beneficiaries.getEmailBen();
            int localityID = beneficiaries.getLocalityID();
            String environment = beneficiaries.getEnvironment();
            int CardID = beneficiaries.getCardID();

            cards = cardsService.findById(CardID)
                                .orElse(null);
            localities = localitiesService.findById(localityID)
                                          .orElse(null);

            beneficiariesList.remove(beneficiaries);

            displayData = new DisplayData(benID, name, surname, phone, idnp, address, email, localityID,
                    localities.getLocalityName(), environment, CardID, cards.getCardNr());
            displayDataList.add(displayData);
        }

        return displayDataList;
    }

    @Override
    public Optional<DisplayData> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(DisplayData entity) {
        Localities locality = localitiesService.getLocality(entity.getLocalityName());
        Cards card = cardsService.getCard(entity.getCardNumber());

        int number = beneficiariesService.findAll()
                                         .size() + 1;
        String code = "BEN" + number;
        entity.setCodeBen(code);
        Beneficiaries beneficiary = new Beneficiaries(entity.getCodeBen(), entity.getNameBen(),
                entity.getSurnameBen(), entity.getPhoneBen(), entity.getIDNP(), entity.getAddressBen(),
                entity.getEmailBen(), locality.getID(), entity.getEnvironment(), card.getID());

        beneficiariesService.save(beneficiary);
    }

    @Override
    public void update(DisplayData entity) {
        Beneficiaries beneficiary = beneficiariesService.getBeneficiary(entity.getCodeBen());
        Localities locality = localitiesService.getLocality(entity.getLocalityName());
        Cards card = cardsService.getCard(entity.getCardNumber());

        beneficiary.setNameBen(entity.getNameBen());
        beneficiary.setSurnameBen(entity.getSurnameBen());
        beneficiary.setPhoneBen(entity.getPhoneBen());
        beneficiary.setIDNP(entity.getIDNP());
        beneficiary.setAddressBen(entity.getAddressBen());
        beneficiary.setEmailBen(entity.getEmailBen());

        beneficiariesService.update(beneficiary);
        localitiesService.update(locality);
        cardsService.update(card);
    }

    @Override
    public void deleteById(DisplayData entity) {

    }
}