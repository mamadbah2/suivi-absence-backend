package sn.dev.suiviabsence.presentation.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceRequestDto {
    private String etudiantId;
    private String coursId;
    private String date;
    private String heure;
    private String justification;
    private String status;
} 