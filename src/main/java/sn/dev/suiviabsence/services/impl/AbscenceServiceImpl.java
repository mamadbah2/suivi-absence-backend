package com.suiviabsence.mobile.service.impl;

@Service
@RequiredArgsConstructor
public class AbsenceMobileServiceImpl implements AbsenceMobileService {

    private final AbsenceRepository absenceRepo;
    private final EtudiantRepository etudiantRepo;
    private final FichierStorageService fileService;
    private final ModelMapper mapper;

    @Override
    public List<AbsenceResponse> getAbsencesByStudent(Long etudiantId) {
        return absenceRepo.findByEtudiantId(etudiantId).stream()
                .map(this::convertToAbsenceResponse)
                .toList();
    }

    @Override
    public AbsenceResponse validateJustification(Long absenceId, ValidationJustificationRequest request) {
        Absence absence = absenceRepo.findById(absenceId)
                .orElseThrow(() -> new RuntimeException("Absence non trouvée"));
        
        absence.setStatut(request.getStatut());
        absence.setCommentaireAdmin(request.getCommentaireAdmin());
        
        return convertToAbsenceResponse(absenceRepo.save(absence));
    }

    @Override
    public AbsenceResponse uploadJustification(Long absenceId, UploadJustificationRequest request) {
        Absence absence = absenceRepo.findById(absenceId)
                .orElseThrow(() -> new RuntimeException("Absence non trouvée"));
        
        String fileName = fileService.storeFile(request.getFichier());
        absence.setFichierJustificatifUrl("/uploads/" + fileName);
        absence.setStatut("EN_ATTENTE");
        
        return convertToAbsenceResponse(absenceRepo.save(absence));
    }

    private AbsenceResponse convertToAbsenceResponse(Absence absence) {
        AbsenceResponse response = mapper.map(absence, AbsenceResponse.class);
        response.setEtudiantNom(absence.getEtudiant().getNomComplet());
        response.setEtudiantMatricule(absence.getEtudiant().getMatricule());
        response.setCoursNom(absence.getCours().getIntitule());
        response.setCoursCode(absence.getCours().getCode());
        return response;
    }
}
