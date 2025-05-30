package sn.dev.suiviabsence.services;

import sn.dev.suiviabsence.web.dto.response.DernierPointageResponseDto;
import java.util.List;

public interface DerniersPointagesService {
    List<DernierPointageResponseDto> getDerniersPointages();
} 