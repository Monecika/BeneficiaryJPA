package ceiti.md.beneficiaryfx.model.repositories;


import ceiti.md.beneficiaryfx.model.entities.Beneficiaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiariesRepository extends JpaRepository<Beneficiaries, Integer> {
}


