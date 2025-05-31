package sn.dev.suiviabsence.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.dev.suiviabsence.dto.requests.EnvoiJustificatifRequest;
import sn.dev.suiviabsence.dto.responses.JustificatifResponse;
import sn.dev.suiviabsence.exceptions.StorageException;
import sn.dev.suiviabsence.models.*;
import sn.dev.suiviabsence.repositories.*;
import sn.dev.suiviabsence.services.FichierStorageService;

@Service
@Transactional
public class JustificatifServiceImpl implements JustificatifService {

    private final JustificatifRepository justificatifRepo;
    private final EtudiantRepository etudiantRepo;
    private final FichierStorageService storageService;

    public JustificatifServiceImpl(/...injection des dépendances.../) {
        
    }

    @Override
    public JustificatifResponse enregistrerJustificatif(EnvoiJustificatifRequest requete) {
        // Vérifier l'étudiant
        Etudiant etudiant = etudiantRepo.findById(requete.getEtudiantId())
                .orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé"));
        
        // Stocker le fichier
        String nomFichier = storageService.stockerFichier(requete.getFichier());
        
        // Enregistrer en base
        Justificatif justificatif = new Justificatif();
        justificatif.setEtudiant(etudiant);
        justificatif.setNomFichier(nomFichier);
        justificatif.setCommentaire(requete.getCommentaireEtudiant());
        justificatif.setStatut("REÇU");
        justificatif.setDateDepot(LocalDateTime.now());
        
        Justificatif saved = justificatifRepo.save(justificatif);
        
        // Retourner la réponse
        return mapToResponse(saved, etudiant);
    }
    
    private JustificatifResponse mapToResponse(Justificatif j, Etudiant e) {
    }
}
