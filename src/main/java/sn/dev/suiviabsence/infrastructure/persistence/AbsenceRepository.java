package sn.dev.suiviabsence.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sn.dev.suiviabsence.core.domain.Absence;
import java.util.List;

@Repository
public interface AbsenceRepository extends MongoRepository<Absence, String> {
  List<Absence> findTop5ByOrderByDateDesc();

  Absence findByStatusAndCours_Classe_Nom(String status, String classe);

  List<Absence> findByCours_Classe_Nom(String classe);

  List<Absence> findByStatus(String status);
}