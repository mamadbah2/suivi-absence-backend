package sn.dev.suiviabsence.data.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sn.dev.suiviabsence.data.entities.Etudiant;
import sn.dev.suiviabsence.data.entities.User;

import java.util.Optional;

@Repository
public interface EtudiantRepository extends MongoRepository<Etudiant, String> {
    Optional<Etudiant> findByEmail(String email);
}
