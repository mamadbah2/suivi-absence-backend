package sn.dev.suiviabsence.core.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import sn.dev.suiviabsence.core.service.DerniersPointagesService;
import sn.dev.suiviabsence.core.mapper.MapperAbsence;
import sn.dev.suiviabsence.infrastructure.persistence.AbsenceRepository;
import sn.dev.suiviabsence.presentation.api.dto.response.DernierPointageDto;

@Service
@RequiredArgsConstructor
public class DerniersPointagesServiceImpl implements DerniersPointagesService {

  private final AbsenceRepository absenceRepository;

  @Override
  public List<DernierPointageDto> getDerniersPointages() {
    return absenceRepository.findTop5ByOrderByDateDesc()
        .stream()
        .map(MapperAbsence::toDernierPointageDto)
        .collect(Collectors.toList());
  }
}