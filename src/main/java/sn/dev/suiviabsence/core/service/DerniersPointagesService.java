package sn.dev.suiviabsence.core.service;

import java.util.List;
import sn.dev.suiviabsence.presentation.api.dto.response.DernierPointageDto;

public interface DerniersPointagesService {
  List<DernierPointageDto> getDerniersPointages();
}