package sn.dev.suiviabsence.data.enums;

public enum StatutAbsence {

    //Absence non justifiée (par défaut)
     
    NON_JUSTIFIEE,
    
    // Absence avec justification en attente de validation

    JUSTIFIEE_EN_ATTENTE,
    
   // Absence justifiée et validée par l'administration

    JUSTIFIEE_VALIDEE,
    
    //Absence justifiée mais refusée par l'administration
    
    JUSTIFIEE_REFUSEE;
    
  
    public boolean estValide() {
        return this == JUSTIFIEE_VALIDEE;
    }
    
    
    public boolean estEnAttente() {
        return this == JUSTIFIEE_EN_ATTENTE;}
}
