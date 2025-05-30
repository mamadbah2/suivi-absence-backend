package com.suiviabsence.mobile.dto.request;

import lombok.Data;

@Data
public class ValidationJustificationRequest {
    private String statut; // "VALIDEE" ou "REJETEE"
    private String commentaireAdmin;
}