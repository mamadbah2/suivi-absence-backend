package sn.dev.suiviabsence.dto.requests;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class ValidationJustificationRequest {
    
    @NotNull(message = "Le statut est obligatoire")
    @Pattern(regexp = "VALIDEE|REJETEE", message = "Le statut doit être VALIDEE ou REJETEE")
    private String statut;
    
    @Size(max = 255, message = "Le commentaire ne doit pas dépasser 255 caractères")
    private String commentaireAdmin;
    
    @NotNull(message = "L'ID du validateur est obligatoire")
    private Long validateurId;
}
