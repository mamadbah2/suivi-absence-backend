package sn.dev.suiviabsence.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.dev.suiviabsence.dto.requests.EnvoiJustificatifRequest;
import sn.dev.suiviabsence.dto.responses.JustificatifResponse;
import sn.dev.suiviabsence.services.JustificatifService;

@RestController
@RequestMapping("/api/justificatifs")
public class JustificatifController {

    private final JustificatifService justificatifService;

    public JustificatifController(JustificatifService justificatifService) {
        this.justificatifService = justificatifService;
    }

    @PostMapping(value = "/depot", consumes = "multipart/form-data")
    public ResponseEntity<JustificatifResponse> deposerJustificatif(
            @ModelAttribute EnvoiJustificatifRequest requete) {
        return ResponseEntity.ok(justificatifService.enregistrerJustificatif(requete));
    }
}
