package sn.dev.suiviabsence.mobile.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import sn.dev.suiviabsence.data.entities.Absence;
@AllArgsConstructor
@Data
public class AbsenceMobileSimpleResponse {
    private String nomModule;
    private String dateDebut;
    private String dateFin;
    private String justification;
    private String status;

    public void AbsenceResponse(Absence absence) {
        this.nomModule = absence.getCours().getModule().getNom();
        this.dateDebut = absence.getCours().getHeureDebut();
        this.dateFin = absence.getCours().getHeureFin();
        this.justification = absence.getJustification();
        this.status = absence.getStatus();
    }
}
