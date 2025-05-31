package sn.dev.suiviabsence.presentation.api.controller.impl;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import sn.dev.suiviabsence.core.service.DerniersPointagesService;
import sn.dev.suiviabsence.presentation.api.controller.DerniersPointagesController;
import sn.dev.suiviabsence.presentation.api.dto.response.DernierPointageDto;

@RestController
@RequiredArgsConstructor
public class DerniersPointagesControllerImpl implements DerniersPointagesController {

  private final DerniersPointagesService derniersPointagesService;

  @Override
  public ResponseEntity<List<DernierPointageDto>> getDerniersPointages() {
    return ResponseEntity.ok(derniersPointagesService.getDerniersPointages());
  }
}