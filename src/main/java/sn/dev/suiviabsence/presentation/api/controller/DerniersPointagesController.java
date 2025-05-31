package sn.dev.suiviabsence.presentation.api.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.dev.suiviabsence.presentation.api.dto.response.DernierPointageDto;

@RestController
@RequestMapping("/derniers-pointages")
public interface DerniersPointagesController {

  @GetMapping
  ResponseEntity<List<DernierPointageDto>> getDerniersPointages();
}