package sn.dev.suiviabsence.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.dev.suiviabsence.data.entities.Absence;
import sn.dev.suiviabsence.data.enums.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceSimpleResponseDto {
    private String matricule;
    private String nom;
    private String prenom;
    private String classe;
    private String module;
    private String date;
    private String heure;
    private String justification;
    private Status status;

    public void AbsenceResponse(Absence absence) {
        this.matricule = absence.getEtudiant().getMatricule();
        this.nom = absence.getEtudiant().getNom();
        this.prenom = absence.getEtudiant().getPrenom();
        this.classe = absence.getCours().getClasse().getNom();
        this.module = absence.getCours().getModule().getNom();
        this.justification = absence.getJustification();
        this.date = absence.getDate();
        this.heure = absence.getHeure();
        this.status = absence.getStatus();
    }
}
