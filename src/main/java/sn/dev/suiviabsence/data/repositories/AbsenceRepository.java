package sn.dev.suiviabsence.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sn.dev.suiviabsence.data.entities.Absence;


@Repository
public interface AbsenceRepository extends MongoRepository<Absence, String> {
}
