package sn.dev.suiviabsence.web.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.dev.suiviabsence.services.DerniersPointagesService;
import sn.dev.suiviabsence.web.controllers.DerniersPointagesController;
import sn.dev.suiviabsence.web.dto.response.DernierPointageResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/derniers-pointages")
@RequiredArgsConstructor
public class DerniersPointagesControllerImpl implements DerniersPointagesController {

    private final DerniersPointagesService derniersPointagesService;

    @Override
    @GetMapping
    public ResponseEntity<List<DernierPointageResponseDto>> getDerniersPointages() {
        return ResponseEntity.ok(derniersPointagesService.getDerniersPointages());
    }
} 