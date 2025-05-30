package com.suiviabsence.mobile.dto.requests;

import lombok.Data;

@Data
public class ValidationJustificationRequest {
    private String statut; // "VALIDEE" ou "REJETEE"
    private String commentaireAdmin;
}