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

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Service
public class DisplayDataService implements MyCrudRepository<DisplayData> {
    private final BeneficiariesService beneficiariesService;
    private final LocalitiesService localitiesService;
    private final CardsService cardsService;
    private final EnvironmentsService environmentsService;

    @Autowired
    public DisplayDataService(BeneficiariesService beneficiariesService, LocalitiesService localitiesService,
                              CardsService cardsService, EnvironmentsService environmentsService) {
        this.beneficiariesService = beneficiariesService;
        this.localitiesService = localitiesService;
        this.cardsService = cardsService;
        this.environmentsService = environmentsService;
    }

    private static DisplayData getDisplayData(Beneficiaries beneficiary) {
        String cardNumber = beneficiary.getCard()
                                       .getCardNr();
        String environmentName = beneficiary.getLocality()
                                            .getEnvironment()
                                            .getEnvironment()
                ;
        String localityName = beneficiary.getLocality()
                                         .getLocalityName();

        DisplayData displayData = new DisplayData(beneficiary.getCodeBen(), beneficiary.getNameBen(),
                beneficiary.getSurnameBen(), beneficiary.getPhoneBen(), beneficiary.getIDNP(),
                beneficiary.getAddressBen(), beneficiary.getEmailBen(), localityName, environmentName, cardNumber);
        return displayData;
    }

    private static DisplayData getScepticDisplayData(Beneficiaries beneficiary) {
        DisplayData displayData = new DisplayData(beneficiary.getCodeBen(), beneficiary.getNameBen(),
                beneficiary.getSurnameBen(), beneficiary.getPhoneBen(), beneficiary.getAddressBen(),
                beneficiary.getEmailBen());
        return displayData;
    }

    private static String generateRandomCardNumber() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            cardNumber.append(random.nextInt(10));
        }

        return cardNumber.toString();
    }

    @Override
    public ObservableList<DisplayData> findAll() {
        ObservableList<DisplayData> displayDataList = FXCollections.observableArrayList();
        ObservableList<Beneficiaries> beneficiariesList = beneficiariesService.findAll();

        for (Beneficiaries beneficiary : beneficiariesList) {
            DisplayData displayData = getDisplayData(beneficiary);
            displayDataList.add(displayData);
        }

        return displayDataList;
    }

    public ObservableList<DisplayData> findAllSceptic() {
        ObservableList<DisplayData> displayDataList = FXCollections.observableArrayList();
        ObservableList<Beneficiaries> beneficiariesList = beneficiariesService.findAll();

        for (Beneficiaries beneficiary : beneficiariesList) {
            DisplayData displayData = getScepticDisplayData(beneficiary);
            displayDataList.add(displayData);
        }

        return displayDataList;
    }

    @Override
    public Optional<DisplayData> findById(int id) {
        Optional<Beneficiaries> beneficiaryOptional = beneficiariesService.findById(id);

        if (beneficiaryOptional.isPresent()) {
            Beneficiaries beneficiary = beneficiaryOptional.get();

            return Optional.of(getDisplayData(beneficiary));
        }
        return Optional.empty();
    }

    @Override
    public void save(DisplayData displayData) {
        Random random = new Random();

        Localities locality = localitiesService.getLocality(displayData.getLocality());
        String environment = displayData.getEnvironment();

        LocalDate expirationDate = LocalDate.now()
                                            .plusYears(4)
                                            .withDayOfMonth(1)
                ;
        Date daexpire = Date.valueOf(expirationDate);

        String codeBen = "BEN" + (beneficiariesService.findAll()
                                                      .size() + 1);

        Beneficiaries beneficiary = new Beneficiaries(codeBen, displayData.getName(), displayData.getSurname(),
                displayData.getPhoneNumber(), displayData.getIdnp(), displayData.getAddress(), displayData.getEmail()
                , locality, environment, null);

        beneficiariesService.save(beneficiary);

        Cards card = new Cards(generateRandomCardNumber(), String.valueOf(random.nextInt(4) + 1), daexpire,
                beneficiary);
        beneficiary.setCard(card);

        cardsService.save(card);
        beneficiariesService.update(beneficiary);
    }


    @Override
    public void update(DisplayData displayData) {
        Beneficiaries beneficiary = beneficiariesService.getBeneficiary(displayData.getCodeBen());
        Localities locality = localitiesService.getLocality(displayData.getLocality());
        Cards card = cardsService.getCard(displayData.getCardNumber());

        beneficiary.setNameBen(displayData.getName());
        beneficiary.setSurnameBen(displayData.getSurname());
        beneficiary.setPhoneBen(displayData.getPhoneNumber());
        beneficiary.setIDNP(displayData.getIdnp());
        beneficiary.setAddressBen(displayData.getAddress());
        beneficiary.setEmailBen(displayData.getEmail());
        beneficiary.setLocality(locality);
        beneficiary.setCard(card);

        beneficiariesService.update(beneficiary);
    }

    @Override
    public void deleteById(DisplayData displayData) {
        Beneficiaries beneficiary = beneficiariesService.getBeneficiary(displayData.getCodeBen());
        beneficiariesService.deleteById(beneficiary);
    }
}
