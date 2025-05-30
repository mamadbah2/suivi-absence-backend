package sn.dev.suiviabsence.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sn.dev.suiviabsence.data.entities.Cours;

import java.util.List;
import java.util.Optional;


@Repository
public interface CoursRepository extends MongoRepository<Cours, String> {
    List<Cours> findByDate(String s);
}
