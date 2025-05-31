package sn.dev.suiviabsence.services;

import sn.dev.suiviabsence.dto.requests.EnvoiJustificatifRequest;
import sn.dev.suiviabsence.dto.responses.JustificatifResponse;

public interface JustificatifService {
    JustificatifResponse enregistrerJustificatif(EnvoiJustificatifRequest requete);
}
