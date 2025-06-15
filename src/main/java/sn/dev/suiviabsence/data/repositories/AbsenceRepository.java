package sn.dev.suiviabsence.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.data.enums.Status;
import sn.dev.suiviabsence.mobile.dto.response.AbsenceMobileSimpleResponse;

import org.springframework.data.domain.Pageable;
import java.util.List;


@Repository
    public interface AbsenceRepository extends MongoRepository<Absence, String> {
        List<Absence> findByEtudiantId(String etudiantId);
        Page<Absence> findAll(Pageable pageable);
        Page<Absence> findByStatusNot(Status status, Pageable pageable);

    }
