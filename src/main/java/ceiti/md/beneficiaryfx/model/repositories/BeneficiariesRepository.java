package ceiti.md.beneficiaryfx.model.repositories;

import ceiti.md.beneficiaryfx.model.entities.Beneficiaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeneficiariesRepository extends JpaRepository<Beneficiaries, Integer> {
    Optional<Beneficiaries> findByCodeBen(String codeBen);
    void deleteByCodeBen(String codeBen);
}
